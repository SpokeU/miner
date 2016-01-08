package app.miner.module.step;

import app.guice.AppInjector;
import app.miner.api.StepProcessor;
import app.miner.models.Step;
import app.miner.models.StepConfiguration;
import app.miner.module.Modules;
import app.miner.module.Properties;
import com.google.inject.Guice;

import javax.inject.Singleton;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Singleton
public class StepProcessorFactory {

    public List<StepProcessor> getStepProcessorsForJob(Long jobId) {
        List<Step> steps = Step.findStepsForJob(jobId);
        List<StepProcessor> stepProcessors = steps.stream().map(s -> createStepProcessor(s)).collect(Collectors.toList());
        return stepProcessors;
    }

    public StepProcessor createStepProcessor(Step step) {
        Class<StepProcessor> stepProcessorClass = getStepProcessorClass(step.getKey());
        StepProcessor stepProcessor = createStepProcessorInstance(stepProcessorClass);
        initializeStepProcessor(stepProcessor, step);
        return stepProcessor;
    }

    private Class<StepProcessor> getStepProcessorClass(String stepKey) {
        Class<StepProcessor> processorClass = null;
        String processorClassName = Modules.forKey(stepKey).getProperty(Properties.StepProperties.PROCESSOR_CLASS);
        if (processorClassName == null) {
            processorClassName = generateProcessorClassName(stepKey);
        }

        try {
            processorClass = (Class<StepProcessor>) Class.forName(processorClassName).asSubclass(StepProcessor.class);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return processorClass;
    }


    private StepProcessor createStepProcessorInstance(Class<StepProcessor> clazz) {
        return Guice.createInjector(new AppInjector()).getInstance(clazz);
    }

    private void initializeStepProcessor(StepProcessor stepProcessor, Step step) {
        Map<String, Object> configMap = step.getConfig().stream()
                .collect(Collectors.toMap(StepConfiguration::getName, StepConfiguration::getValue));
        stepProcessor.initialize(configMap);
    }

    private String generateProcessorClassName(String stepKey) {
        return "not implemented";
    }

}
