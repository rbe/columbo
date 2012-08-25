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

package eu.artofcoding.grownloader2;

import eu.artofcoding.grownloader2.spring.Slf4j;
import eu.artofcoding.grownloader2.spring.SpringContextHelper;
import org.slf4j.Logger;
import org.springframework.batch.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ErroredExecutionListener implements JobExecutionListener, StepExecutionListener {

    @Slf4j
    private static Logger logger;

    @Autowired
    private SpringContextHelper springContextHelper;

    @Override
    public void beforeStep(StepExecution stepExecution) {
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        return stepExecution.getExitStatus();
    }

    @Override
    public void beforeJob(JobExecution jobExecution) {
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        // Job failed?
        if (jobExecution.getExitStatus().equals(ExitStatus.FAILED)) {
            logger.info(String.format("Got %s", jobExecution.getExitStatus()));
            for (Throwable t : jobExecution.getAllFailureExceptions()) {
                logger.error(String.format("%s, throwable is %s", jobExecution.getExitStatus().getExitCode(), t.getCause()));
            }
            final Throwable t = jobExecution.getAllFailureExceptions().get(0);
            springContextHelper.shutdownDueToException(t);
        }
    }

}
