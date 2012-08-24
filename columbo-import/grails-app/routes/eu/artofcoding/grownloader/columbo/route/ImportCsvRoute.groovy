/*
 * corma GmbH, Project Columbo
 * Copyright (C) 2011 art of coding UG (haftungsbeschränkt).
 *
 * Nutzungslizenz siehe http://files.art-of-coding.eu/aoc/AOCPL_v10_de.html
 * Use is subject to license terms, see http://files.art-of-coding.eu/aoc/AOCPL_v10_en.html
 *
 */
package eu.artofcoding.grownloader.columbo.route

import org.codehaus.groovy.grails.commons.ConfigurationHolder as GCH

/**
 * Route for forwarding splitted CSV files to the database.
 */
class ImportCsvRoute {
    
    /**
     * Grails configuration.
     */
    def config = GCH.config
    
    /**
     * The 'Import CSV' service.
     */
    def importCsvService
    
    /**
     * Configure this route.
     */
    def configure = {
        // Error handler
        errorHandler(defaultErrorHandler().maximumRedeliveries(1))
        // Setup route to ImportCsvService
        from("file://${config.columbo.splitter.directories.success}"
             + "?readLock=${config.columbo.splitter.camel.readLock}"
             + "&readLockTimeout=${config.columbo.splitter.camel.readLockTimeout}"
             + '&maxMessagesPerPoll=10'
             + '&idempotent=true'
             + '&recursive=false'
             + '&move=../done'
             + '&moveFailed=../error')
        .to('bean:importCsvService?method=toStage1')
        .to('bean:importCsvService?method=toStage2')
        .process { exchange ->
            def len = Math.round((double) exchange.in.headers.CamelFileLength / 1024 / 1024)
            def suc = exchange.in.headers.fault ? 'UNSUCCESSFULLY' : 'SUCCESSFULLY'
            exchange.out.setHeader 'Subject', "${suc} processed ${exchange.in.headers.CamelFileName}".toString()
            exchange.out.setBody "${suc} imported ${len} MB from ${exchange.in.headers.CamelFileName} into stage 2".toString()
            exchange.out.setHeader 'From', config.columbo.mail.from
            exchange.out.setHeader 'To', config.columbo.mail.to
        }.to("smtps://${config.columbo.mail.hostname}:${config.columbo.mail.port}"
             + "?username=${config.columbo.mail.username}"
             + "&password=${config.columbo.mail.password}")
    }
    
}
