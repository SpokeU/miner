package app.parser.step;

import app.parser.models.Step;
import app.parser.models.StepConfig;

import javax.inject.Singleton;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Singleton
public class StepProcessorFactory {

    public List<StepProcessor> getStepProcessorsForJob(Long jobId) {
        List<Step> steps = Step.findStepsForJob();
        List<StepProcessor> stepProcessors = steps.stream().map(s -> createParseStep(s)).collect(Collectors.toList());
        return stepProcessors;
    }

    public StepProcessor createParseStep(Step model) {
        AbstractStepProcessor step = createStepInstance(model.getClazz());
        Map<String, Object> configMap = model.getConfig().stream().collect(Collectors.toMap(StepConfig::getName, StepConfig::getValue));
        step.initialize(configMap);
        return step;
    }

    private <T> T createStepInstance(String clazz) {
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

