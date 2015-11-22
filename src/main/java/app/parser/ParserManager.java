package app.parser;

import app.parser.step.StepProcessor;
import app.parser.step.StepProcessorExecutor;
import app.parser.step.StepProcessorFactory;

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
