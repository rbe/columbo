package eu.artofcoding.grownloader2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.*;
import org.springframework.beans.factory.annotation.Autowired;

public class ErroredExecutionListener implements JobExecutionListener, StepExecutionListener {

    private static final Logger logger = LoggerFactory.getLogger(ErroredExecutionListener.class.getName());

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
        logger.info("Got " + jobExecution.getExitStatus());
        for (Throwable t : jobExecution.getAllFailureExceptions()) {
            logger.error(jobExecution.getExitStatus().getExitCode() + ", throwable is " + t.getCause());
        }
        final Throwable t = jobExecution.getAllFailureExceptions().get(0);
        springContextHelper.shutdownDueToException(t);
        /*
        new Thread(new Runnable() {
            @Override
            public void run() {
                springContextHelper.shutdownDueToException(t);
            }
        }).start();
        */
    }

}
