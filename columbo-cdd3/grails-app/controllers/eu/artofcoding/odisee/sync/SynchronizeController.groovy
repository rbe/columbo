/*
 * Odisee Sync
 *
 * Copyright (C) 2009-2010 Informationssysteme Ralf Bensmann.
 * Copyright (C) 2011-2012 art of coding UG (haftungsbeschränkt).
 *
 * Alle Rechte vorbehalten. Nutzung unterliegt Lizenzvereinbarungen.
 * All rights reserved. Use is subject to license terms.
 */
package eu.artofcoding.odisee.sync

import org.codehaus.groovy.grails.commons.GrailsApplication

class SynchronizeController {

    /**
     * GrailsApplication.
     */
    GrailsApplication grailsApplication

    /**
     * Synchronization service.
     */
    def synchronizeService

    /**
     * Index.
     */
    def index() {
        render "${this}"
    }

    /**
     * Sync a table.
     */
    def sync() {
        println "${this}.sync: project=${params.project}, table=${params.table}"
        synchronizeService.copyTable(params.project, params.table)
    }

}
