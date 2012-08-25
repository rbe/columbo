/*
 * columbo
 * columbo-grownloader2
 * Copyright (C) 2010-2010 Informationssysteme Ralf Bensmann, http://www.bensmann.com/
 * Copyright (C) 2011-2012 art of coding UG, http://www.art-of-coding.eu/
 *
 * Alle Rechte vorbehalten. Nutzung unterliegt Lizenzbedingungen.
 * All rights reserved. Use is subject to license terms.
 *
 * rbe, 8/24/12 10:46 AM
 */

package eu.artofcoding.grownloader2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersIncrementer;

public class DynamicJobParameterIncrementer implements JobParametersIncrementer {

    private static final Logger logger = LoggerFactory.getLogger(DynamicJobParameterIncrementer.class.getName());

    @Override
    public JobParameters getNext(JobParameters parameters) {
        // TODO Do not overwrite old parameters
        parameters = new JobParametersBuilder().addLong("currentTime", System.currentTimeMillis()).toJobParameters();
        logger.info(String.format("incremented job parameters: %s", parameters.toString()));
        return parameters;
    }

}
