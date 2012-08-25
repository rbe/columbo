/*
 * columbo
 * columbo-grownloader2
 * Copyright (C) 2010-2010 Informationssysteme Ralf Bensmann, http://www.bensmann.com/
 * Copyright (C) 2011-2012 art of coding UG, http://www.art-of-coding.eu/
 *
 * Alle Rechte vorbehalten. Nutzung unterliegt Lizenzbedingungen.
 * All rights reserved. Use is subject to license terms.
 *
 * rbe, 8/24/12 1:25 PM
 */

package eu.artofcoding.grownloader2;

import eu.artofcoding.grownloader2.spring.SpringContextHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * This scheduler starts jobs using one parameter "currentTime" to allow repeated executions
 * and is sensitive to exceptions: when an exception was thrown, stop execution.
 */
public class SpringSchedulingLauncher {

    private static Logger logger = LoggerFactory.getLogger(SpringSchedulingLauncher.class);

    @Autowired
    private SpringContextHelper springContextHelper;

    private Job job;
    private JobLauncher jobLauncher;

    private final AtomicBoolean RUNNING = new AtomicBoolean(false);
    private final AtomicBoolean GOT_EXCEPTION = new AtomicBoolean(false);

    public void setJob(Job job) {
        this.job = job;
    }

    public void setJobLauncher(JobLauncher jobLauncher) {
        this.jobLauncher = jobLauncher;
    }

    public void launch() throws Exception {
        if (!GOT_EXCEPTION.get()) {
            try {
                JobParameters jobParameters = new JobParametersBuilder().addLong("currentTime", System.currentTimeMillis()).toJobParameters();
                /*JobExecution jobExecution =*/ jobLauncher.run(job, jobParameters);
                // Wait some time...
                final int msecs = (int) (Math.random() * 100) * 100;
                logger.debug("WAITING " + msecs + " milliseconds");
                Thread.sleep(msecs);
                logger.debug("NOW I AM DONE");
            } catch (Exception e) {
                GOT_EXCEPTION.getAndSet(true);
                springContextHelper.shutdownDueToException(e);
                Thread.currentThread().interrupt();
            }
        } else {
            logger.error("Ooops, something went wrong!");
        }
    }
}
