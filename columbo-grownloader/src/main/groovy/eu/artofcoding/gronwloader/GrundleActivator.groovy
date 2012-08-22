/*
 * Grownloader
 * Copyright (C) 2009-2010 Informationssysteme Ralf Bensmann.
 * Copyright (C) 2011-2012 art of coding UG (haftungsbeschränkt).
 *
 * Alle Rechte vorbehalten. Nutzung unterliegt Lizenzvereinbarungen.
 * All rights reserved. Use is subject to license terms.
 */
package eu.artofcoding.gronwloader

import org.osgi.framework.BundleActivator
import org.osgi.framework.BundleContext
import org.osgi.framework.BundleEvent
import org.osgi.framework.BundleListener
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 *
 */
class GrundleActivator implements BundleActivator {

    /**
     * Logger.
     */
    private static Logger log = LoggerFactory.getLogger(GrundleActivator.class)

    void start(BundleContext context) {
        log.info "GrundleActivator.start"
        new Grownloader().go()
    }

    void stop(BundleContext context) {
        log.info "GrundleActivator.stop"
    }

}
