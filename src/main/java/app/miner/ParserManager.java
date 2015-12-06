package app.miner;

import app.miner.api.StepProcessor;
import app.miner.step.StepProcessorExecutor;
import app.miner.step.StepProcessorFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class ParserManager {

    @Inject
    private StepProcessorFactory stepProcessorFactory;

    @Inject
    private StepProcessorExecutor stepsExecutor;

    public void executeJob(Long jobId){
        List<StepProcessor> stepProcessors = stepProcessorFactory.getStepProcessorsForJob(jobId);
        stepsExecutor.processSteps(stepProcessors);
    }

}
