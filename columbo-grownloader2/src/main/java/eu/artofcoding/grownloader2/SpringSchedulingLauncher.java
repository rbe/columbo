package eu.artofcoding.grownloader2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
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

    private static final Logger logger = LoggerFactory.getLogger(SpringSchedulingLauncher.class.getName());

    @Autowired
    private SpringContextHelper springContextHelper;

    private Job job;
    private JobLauncher jobLauncher;

    private static final AtomicBoolean GOT_EXCEPTION = new AtomicBoolean(false);

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
                jobLauncher.run(job, jobParameters);
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
