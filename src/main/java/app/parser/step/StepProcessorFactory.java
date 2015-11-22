package app.parser.step;

import app.parser.models.Step;
import app.parser.models.StepConfiguration;

import javax.inject.Singleton;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Singleton
public class StepProcessorFactory {

    public List<StepProcessor> getStepProcessorsForJob(Long jobId) {
        List<Step> steps = Step.findStepsForJob(jobId);
        List<StepProcessor> stepProcessors = steps.stream().map(s -> createParseStep(s)).collect(Collectors.toList());
        return stepProcessors;
    }

    public StepProcessor createParseStep(Step step) {
        AbstractStepProcessor stepProcessor = createStepProcessor(step.getClazz());
        Map<String, Object> configMap = step.getConfig().stream().collect(Collectors.toMap(StepConfiguration::getName, StepConfiguration::getValue));
        stepProcessor.initialize(configMap);
        return stepProcessor;
    }

    private <T> T createStepProcessor(String clazz) {
        T step = null;
        try {
            step = (T) Class.forName(clazz).getConstructors()[0].newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return step;
    }
}

