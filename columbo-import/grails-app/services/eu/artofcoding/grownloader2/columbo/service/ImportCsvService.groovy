/*
 * corma GmbH, Project Columbo
 * Copyright (C) 2011 art of coding UG (haftungsbeschränkt).
 *
 * Nutzungslizenz siehe http://files.art-of-coding.eu/aoc/AOCPL_v10_de.html
 * Use is subject to license terms, see http://files.art-of-coding.eu/aoc/AOCPL_v10_en.html
 *
 */
package eu.artofcoding.corma.columbo.service

import eu.artofcoding.corma.columbo.helper.PathHelper as Ph
import eu.artofcoding.corma.columbo.helper.Stage1LoadStoredProcedure
import eu.artofcoding.corma.columbo.helper.Stage2MergeStoredProcedure
import org.apache.commons.dbcp.BasicDataSource
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy

/**
 * 
 */
class ImportCsvService {
    
    /**
     * Scope prototype, one instance per injection.
     */
    static scope = 'prototype'
    
    /**
     * Grails configuration.
     */
    def grailsApplication
    
    /**
     * Use transactions?
     */
    static transactional = false
    
    /**
     * DataSource.
     * org.springframework.beans.factory.BeanCreationException, BeanCreationNotAllowedException
     * Error creating bean 'dataSource': Singleton bean creation not allowed while the singletons of this
     * factory are in destruction.
     */
    //def dataSource
    
    /**
     * Initialize data source.
     * Important, as service injection of singleton dataSource does not work with Camel on Windows?!
     */
    TransactionAwareDataSourceProxy getDataSource() {
        // Get configuration
        def config = grailsApplication.config.columbo.database
        // Build datasource
        BasicDataSource dataSource = new BasicDataSource()
        dataSource.setDriverClassName(config.driverClassName)
        dataSource.setUrl("jdbc:${config.type}://${config.hostname}:${config.port};databaseName=${config.database}")
        dataSource.setUsername(config.username)
        dataSource.setPassword(config.password)
        //
        new TransactionAwareDataSourceProxy(dataSource)
    }
    
    /**
     * Import (previously successfully splitted) CSV files through call to a store procedure into stage 1.
     * @param file A CSV file.
     * @return java.io.File
     */
    java.io.File toStage1(java.io.File file) {
        def dataSource = getDataSource()
        log.debug "ImportCsvService.toStage1: file=${file} dataSource=${dataSource}"
        def shortName
        try {
            // Configuration for stage1
            Map stage1Config = grailsApplication.config.columbo.database.stage1
            // Map parent file... e.g. drive letter under Windows
            def n = file.absolutePath
            stage1Config.nameMap.each { k, v ->
                n = n.replaceAll(k, v)
            }
            // Set short name (just filename without path)
            shortName = Ph.splitBySeparator(n)[-1] //n.split('/')[-1]
            // Strip date, number, extension off of filename: Case_End2End_20100819-093001_0.csv --> Case_End2End
            String contentType = shortName.split('_')[0..-3].join('_')
            // Import file into stage 1
            log.info "${shortName}: Importing file into stage 1, contentType=${contentType}"
            // SQL Server
            if ('sqlserver' == grailsApplication.config.columbo.database.type) {
                // Windows' separator is a backslash
                n = n.split('/').join('\\')
            }
            // Execute stored procedure
            Stage1LoadStoredProcedure storedProc =
                Stage1LoadStoredProcedure.getInstance("stage1.p_load_${contentType.toLowerCase()}", dataSource)
            // Replace slashes with backslashes (Windows paths), and dashes with underscores (SQL Server table name)
            storedProc.execute(n,
                Ph.splitBySeparator("${stage1Config.formatFilePath}/${contentType}.fmt").join('\\'),
                shortName.split('\\.')[0..-2].join('_').replaceAll('-', '_')
            )
            log.info "${shortName}: imported into stage 1."
            // Delete original input file
            //file.delete()
        } catch (e) {
            log.error "${shortName}: EXCEPTION: Cannot import file: ${e}"
            e.printStackTrace()
            throw e
        }
        return file
    }
    
    /**
     * Merge data from stage 1 into stage 2.
     * @param file A CSV file.
     * @return java.io.File
     */
    java.io.File toStage2(java.io.File file) {
        def dataSource = getDataSource()
        log.info "ImportCsvService.toStage2: file=${file} dataSource=${dataSource}"
        def shortName
        try {
            // Configuration for stage1
            Map stage1Config = grailsApplication.config.columbo.database.stage1
            // Absolute file name, incl. path
            def n = file.absolutePath
            // Set short name (just filename without path)
            shortName = Ph.splitBySeparator(n)[-1] //n.split('/')[-1]
            // Strip date, number, extension off of filename: Case_End2End_20100819-093001_0.csv --> Case_End2End
            String contentType = shortName.split('_')[0..-3].join('_')
            // Import file into stage 1
            log.info "${shortName}: Merging data into stage 2, contentType=${contentType}"
            // SQL Server
            if ('sqlserver' == grailsApplication.config.columbo.database.type) {
                // UNIX -> Windows' separator is a backslash
                n = n.split('/').join('\\')
            }
            // Execute stored procedure
            Stage2MergeStoredProcedure storedProc =
                Stage2MergeStoredProcedure.getInstance("stage2.p_merge_all", dataSource)
            // Replace dashes with underscores (SQL Server table name)
            storedProc.execute(
                contentType.toUpperCase(),
                shortName.split('\\.')[0..-2].join('_').replaceAll('-', '_')
            )
            log.info "${shortName}: merged into stage 2."
        } catch (e) {
            log.error "${shortName}: EXCEPTION: Cannot import file: ${e}"
            e.printStackTrace()
            throw e
        }
        return file
    }
    
}
