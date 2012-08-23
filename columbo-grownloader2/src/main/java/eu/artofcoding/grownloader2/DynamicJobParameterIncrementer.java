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
        logger.info("incremented job parameters: " + parameters.toString());
        return parameters;
    }

}
