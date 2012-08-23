/*
 * Odisee Sync
 * corma DataDownloader
 *
 * Copyright (C) 2012 art of coding UG (haftungsbeschränkt).
 *
 * Alle Rechte vorbehalten. Nutzung unterliegt Lizenzvereinbarungen.
 * All rights reserved. Use is subject to license terms.
 */
package eu.artofcoding.corma.cdd

import org.codehaus.groovy.grails.commons.GrailsApplication
import java.sql.CallableStatement
import groovy.sql.Sql

/**
 *
 */
class SyncGCSSJob {

    /**
     * GrailsApplication.
     */
    GrailsApplication grailsApplication

    /**
     * Synchronization service.
     */
    def synchronizeService

    /**
     * Timeout in milliseconds.
     * Did not work with concurrent = false!
     */
    //def timeout = 1 * 1000l // InitializingBean? grailsApplication.config.odisync.timeout

    static triggers = { // InitializingBean? grailsApplication.config.odisync.timeout
        simple name: 'GCSSJobTrigger', startDelay: 5 * 1000, repeatInterval: 1 * 1000
    }

    def concurrent = false

    def execute() {
        int sleep = 0
        String projectName = null
        String sourceTableName = null
        try {
            // Each project
            grailsApplication.config.odisync.each { project ->
                projectName = project.key
                log.info "execute/${projectName}: >>> START >>>"
                // Each table
                project.value.table.each { table ->
                    // Name of source table
                    sourceTableName = table.key
                    log.info "execute/${projectName}/${sourceTableName}: Synchronizing table ${sourceTableName}"
                    Map syncResult = null
                    try {
                        // copyTable() returns name of temporary table where data was copied to
                        syncResult = synchronizeService.copyTable(project.key, sourceTableName)
                        // Merge
                        log.info "execute/${projectName}/${sourceTableName}: Merging table ${sourceTableName} to ${syncResult.table}"
                        // Merge data of new table into existing one
                        Sql conn = synchronizeService.connect(project.key, 'destination')
                        CallableStatement stage2MergeAll = conn.connection.prepareCall('{CALL stage2.p_merge_all(?, ?)}')
                        stage2MergeAll.setString(1, sourceTableName) //@target_table
                        stage2MergeAll.setString(2, syncResult.table.split('[.]')[-1]) //@source_table
                        log.info "execute/${projectName}/${sourceTableName}: ${stage2MergeAll.execute()}"
                        // Remove temporary table
                        synchronizeService.removeTable(projectName, 'destination', syncResult.table)
                    } catch (e) {
                        log.error "execute/${projectName}/${sourceTableName}: Got exception", e
                        // Remove temporary table if its empty
                        if (syncResult.rowCount == 0) {
                            synchronizeService.removeTable(project.key, 'destination', syncResult.table)
                        }
                    }
                    log.info "execute/${projectName}/${sourceTableName}: Synced ${syncResult.rowCount} rows from ${sourceTableName} to ${syncResult.table}"
                }
                // Calculate sleep time
                Date lastSync = synchronizeService.getLastSync(projectName, sourceTableName)
                Date now = new Date()
                if (lastSync.before(now)) {
                    long catchupTimeout = (long) project.value.catchup_timeout
                    if (catchupTimeout == 0) {
                        // Minimum is 2 minutes
                        while (sleep < 120) {
                            sleep = (int) (1000 * Math.random())
                        }
                    } else {
                        sleep = catchupTimeout
                    }
                } else {
                    sleep = project.value.timeout
                }
            }
            log.info "execute/${projectName}: <<< STOP <<<"
        } catch (Exception e) {
            log.error "execute/${projectName}/${sourceTableName}", e
        } finally {
            log.info "execute/${projectName}: Sleeping ${sleep} seconds"
            Thread.sleep(sleep * 1000)
        }

    }

}
