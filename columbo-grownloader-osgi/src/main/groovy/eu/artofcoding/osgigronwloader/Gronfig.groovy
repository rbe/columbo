/*
 * Grownloader
 * Copyright (C) 2009-2010 Informationssysteme Ralf Bensmann.
 * Copyright (C) 2011-2012 art of coding UG (haftungsbeschränkt).
 *
 * Alle Rechte vorbehalten. Nutzung unterliegt Lizenzvereinbarungen.
 * All rights reserved. Use is subject to license terms.
 */
package eu.artofcoding.osgigronwloader

import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 *
 */
@Singleton
class Gronfig {

    /**
     * Logger.
     */
    private static Logger log = LoggerFactory.getLogger(Gronfig.class)

    /**
     * Name of system property for path to configration file.
     */
    private final GROWNLOADER_CONFIG = 'grownloader-config'

    /**
     * Content of system property referenced by GROWNLOADER_CONFIG.
     */
    private final String systemGrownloaderConfigPath

    /**
     * ConfigObject for grownloader-config.
     */
    private final ConfigObject grownloaderConfig

    /**
     *
     */
    private Gronfig() {
        // Get value of system property
        systemGrownloaderConfigPath = System.getProperty(GROWNLOADER_CONFIG, null)
        // Slurp configuration
        log.debug('Loading configuration from {}', systemGrownloaderConfigPath)
        if (null == systemGrownloaderConfigPath) {
            throw new IllegalStateException('Please set grownloader-config system property')
        }
        grownloaderConfig = new ConfigSlurper().parse(new File(systemGrownloaderConfigPath).toURL())
        log.trace('grownloader-config={}', grownloaderConfig.grownloader)
    }

    @Override
    Object getProperty(String property) {
        grownloaderConfig.getProperty(property)
    }

    /**
     * Get parent directory of Grownloader's configuration file.
     * @return
     */
    File getGrownloaderConfigDirectory() {
        new File(systemGrownloaderConfigPath).parentFile
    }
}
