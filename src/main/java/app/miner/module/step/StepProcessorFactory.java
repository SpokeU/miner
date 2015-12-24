package app.miner.module.step;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.inject.Singleton;

import app.miner.api.StepProcessor;
import app.miner.models.Step;
import app.miner.models.StepConfiguration;

@Singleton
public class StepProcessorFactory {

	public List<StepProcessor> getStepProcessorsForJob(Long jobId) {
		List<Step> steps = Step.findStepsForJob(jobId);
		List<StepProcessor> stepProcessors = steps.stream().map(s -> createStepProcessor(s)).collect(Collectors.toList());
		return stepProcessors;
	}

	public StepProcessor createStepProcessor(Step step) {
		AbstractStepProcessor stepProcessor = createStepProcessorInstance(step.getClazz());
		Map<String, Object> configMap = step.getConfig().stream()
				.collect(Collectors.toMap(StepConfiguration::getName, StepConfiguration::getValue));
		stepProcessor.initialize(configMap);
		return stepProcessor;
	}

	private <T> T createStepProcessorInstance(String clazz) {
		T step = null;
		try {
			step = (T) Class.forName(clazz).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return step;
	}
}
