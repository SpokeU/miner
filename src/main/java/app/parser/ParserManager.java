package app.parser;

import app.parser.models.Step;
import app.parser.step.StepProcessor;
import app.parser.step.StepProcessorFactory;
import app.parser.step.StepsExecutor;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Issen on 18.11.2015.
 */
public class ParserManager {

    @Inject
    private StepProcessorFactory stepProcessorFactory;

    @Inject
    private StepsExecutor stepsExecutor;

    public void executeJob(Long jobId){
        List<Step> steps = Step.where(Step.parse_job_id + " = ? order by order", jobId);
        List<StepProcessor> stepProcessors = stepProcessorFactory.getStepProcessorsForJob(jobId);
        stepsExecutor.processSteps(stepProcessors);
    }

}
