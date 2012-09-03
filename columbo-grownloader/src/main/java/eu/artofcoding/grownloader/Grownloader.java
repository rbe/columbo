/*
 * columbo
 * columbo-grownloader2
 * Copyright (C) 2010-2010 Informationssysteme Ralf Bensmann, http://www.bensmann.com/
 * Copyright (C) 2011-2012 art of coding UG, http://www.art-of-coding.eu/
 *
 * Alle Rechte vorbehalten. Nutzung unterliegt Lizenzbedingungen.
 * All rights reserved. Use is subject to license terms.
 *
 * rbe, 8/24/12 11:25 AM
 */

package eu.artofcoding.grownloader;

import eu.artofcoding.grownloader.spring.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

@Component
public class Grownloader {

    @Slf4j
    private static Logger logger;

    private static final CountDownLatch COUNT_DOWN_LATCH = new CountDownLatch(1);
    private static final AtomicBoolean COMPLETED = new AtomicBoolean(false);

    public static void shutdown() {
        COMPLETED.getAndSet(true);
        COUNT_DOWN_LATCH.countDown();
    }

    private static void waitForShutdown() {
        // Wait...
        while (!COMPLETED.get()) {
            try {
                COUNT_DOWN_LATCH.await();
            } catch (InterruptedException e) {
                // ignore...
            }
        }
    }

    private static void performShutdown(FileSystemXmlApplicationContext applicationContext) {
        // Stop Spring
        if (COMPLETED.get()) {
            logger.info("Seems we're finished... stopping Spring application context");
            applicationContext.close();
            logger.info("Closed Spring application context!");
        }
    }

    public static void main(String[] args) {
        // Register shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                shutdown();
            }
        }));
        // Configure and start Spring application context
        final String[] contextXml = new String[]{
                "conf/system/spring-context.xml",
                "conf/datasources.xml",
                "conf/tables.xml"
        };
        try {
            FileSystemXmlApplicationContext applicationContext = new FileSystemXmlApplicationContext(contextXml);
            waitForShutdown();
            performShutdown(applicationContext);
            logger.info("Bye!");
        } catch (BeanCreationException e) {
            //logger.error("Could not startup", e);
            e.printStackTrace();
        }
    }

}
