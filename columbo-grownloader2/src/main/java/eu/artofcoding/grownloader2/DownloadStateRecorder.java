package eu.artofcoding.grownloader2;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

/**
 * Record successful 'last_download' datetime by increasing it by 'download_hours' in state table.
 */
public class DownloadStateRecorder implements Tasklet {

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
