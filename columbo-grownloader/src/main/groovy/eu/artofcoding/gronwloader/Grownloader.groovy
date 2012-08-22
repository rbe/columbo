/*
 * Grownloader
 * Copyright (C) 2009-2010 Informationssysteme Ralf Bensmann.
 * Copyright (C) 2012 art of coding UG (haftungsbeschränkt).
 *
 * Alle Rechte vorbehalten. Nutzung unterliegt Lizenzvereinbarungen.
 * All rights reserved. Use is subject to license terms.
 */
package eu.artofcoding.gronwloader

import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 *
 */
class Grownloader {

    /**
     * Logger.
     */
    private static Logger log = LoggerFactory.getLogger(Grownloader.class)

    /**
     * Grownloader's configuration.
     */
    private static final Gronfig config = Gronfig.instance

    /**
     * The synchronizer.
     */
    private static final Synchronizer synchronizer = new Synchronizer()

    /**
     * Calculate sleep time.
     * @param projectName
     * @param sourceTableName
     * @return
     */
    private static long lastSyncSleep(Map.Entry project, String projectName, String sourceTableName) {
        long sleep = 0l
        Date lastSync = synchronizer.getLastSync(projectName, sourceTableName)
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
        return sleep
    }

    /**
     *
     * @param projectName
     * @param sourceTableName
     */
    private static void synchronizeTable(String projectName, String sourceTableName) {
        log.info "synchronizeTable/${projectName}/${sourceTableName}: Synchronizing table ${sourceTableName}"
        Map syncResult = null
        try {
            // copyTable() returns a map with name of temporary table where data was copied to
            syncResult = synchronizer.copyTable(projectName, sourceTableName)
            // Merge data of new table into existing one
            synchronizer.mergeTable(projectName, sourceTableName, syncResult)
            // Remove temporary table
            synchronizer.removeTable(projectName, 'destination', syncResult.table)
        } catch (e) {
            log.error "synchronizeTable/${projectName}/${sourceTableName}: Got exception '${e.message}'"
            // Remove temporary table if its empty
            if (syncResult.rowCount == 0) {
                synchronizer.removeTable(projectName, 'destination', syncResult.table)
            }
            throw e
        }
        log.info "synchronizeTable/${projectName}/${sourceTableName}: Synced ${syncResult.rowCount} rows from ${sourceTableName} to ${syncResult.table}"
    }

    /**
     *
     */
    public void go() {
        String projectName = null
        String sourceTableName = null
        int sleep = 0
        try {
            // Each project
            config.'grownloader'.each { Map.Entry project ->
                projectName = project.key
                Object projectValue = project.value
                log.info "main/${projectName}: >>> START >>>"
                // Each table
                projectValue.'table'.each { Map.Entry table ->
                    // Name of source table
                    sourceTableName = table.key
                    synchronizeTable(projectName, sourceTableName)
                }
                // Calculate sleep time
                sleep = lastSyncSleep(project, projectName, sourceTableName)
            }
            log.info "main/${projectName}: <<< STOP <<<"
            log.info "main/${projectName}: Sleeping ${sleep} seconds"
            Thread.sleep(sleep * 1000)
        } catch (Exception e) {
            log.error "main/${projectName}/${sourceTableName}: Got exception '${e.message}'"
            //throw e
        }
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        go()
    }

}
