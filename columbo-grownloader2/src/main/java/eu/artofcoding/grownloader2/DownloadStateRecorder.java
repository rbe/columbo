/*
 * columbo
 * columbo-grownloader2
 * Copyright (C) 2010-2010 Informationssysteme Ralf Bensmann, http://www.bensmann.com/
 * Copyright (C) 2011-2012 art of coding UG, http://www.art-of-coding.eu/
 *
 * Alle Rechte vorbehalten. Nutzung unterliegt Lizenzbedingungen.
 * All rights reserved. Use is subject to license terms.
 *
 * rbe, 8/23/12 2:22 PM
 */

package eu.artofcoding.grownloader2;

import eu.artofcoding.grownloader2.spring.Slf4j;
import org.slf4j.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

/**
 * Record successful 'last_download' datetime by increasing it by 'download_hours' in state table.
 */
@Component
public class DownloadStateRecorder implements Tasklet {

    @Slf4j
    private Logger logger;

    private StateHelper stateHelper;

    public void setStateHelper(StateHelper stateHelper) {
        this.stateHelper = stateHelper;
    }

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        stateHelper.nextState();
        return RepeatStatus.FINISHED;
    }

}
