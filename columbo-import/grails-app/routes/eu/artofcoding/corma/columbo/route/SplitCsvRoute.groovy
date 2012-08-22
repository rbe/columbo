/*
 * corma GmbH, Project Columbo
 * Copyright (C) 2011 art of coding UG (haftungsbeschränkt).
 *
 * Nutzungslizenz siehe http://files.art-of-coding.eu/aoc/AOCPL_v10_de.html
 * Use is subject to license terms, see http://files.art-of-coding.eu/aoc/AOCPL_v10_en.html
 *
 */
package eu.artofcoding.corma.columbo.route

import org.codehaus.groovy.grails.commons.ConfigurationHolder as GCH

/**
 * Route for split incoming CSV files.
 */
class SplitCsvRoute {
    
    /**
     * Grails configuration.
     */
    def config = GCH.config
    
    /**
     * The 'Split CSV' service.
     */
    def splitCsvService
    
    /**
     * The 'Import CSV' service.
     */
    def importCsvService
    
    /**
     * Configure this route.
     */
    def configure = {
        // Show configuration at startup
        config.flatten().each { k, v ->
            if (k.startsWith('columbo') && !k.contains('pass')) {
                println String.format("ImportCsvRoute.configure: config.%-50s -> %s", k, v)
            }
        }
        // Error handler
        errorHandler(defaultErrorHandler().maximumRedeliveries(1))
        // Create directories
        config.columbo.splitter.directories.each { k, v ->
            java.io.File f = new java.io.File(v)
            println "Creating directory columbo.splitter.directories.${k} at ${f.absolutePath}"
            f.mkdirs()
        }
        // Setup route to SplitCsvService
        from("file://${config.columbo.splitter.directories.input}"
             + "?readLock=${config.columbo.splitter.camel.readLock}"
             + "&readLockTimeout=${config.columbo.splitter.camel.readLockTimeout}"
             + '&maxMessagesPerPoll=10'
             + '&idempotent=true'
             + '&recursive=false'
             + '&move=../done'
             + '&moveFailed=../error')
        .to('bean:splitCsvService?method=analyzeAndSplit')
    }
    
}
