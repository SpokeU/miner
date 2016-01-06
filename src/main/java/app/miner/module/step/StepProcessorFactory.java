package app.miner.module.step;

import app.miner.api.StepProcessor;
import app.miner.models.Step;
import app.miner.models.StepConfiguration;
import app.miner.module.Module;
import app.miner.module.Modules;
import app.miner.module.Properties;

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
		Module module = Modules.forKey(step.getKey());
		String processorClass = module.getProperty(Properties.StepProperties.PROCESSOR_CLASS);
		AbstractStepProcessor stepProcessor = createStepProcessorInstance(processorClass);
		Map<String, Object> configMap = step.getConfig().stream()
				.collect(Collectors.toMap(StepConfiguration::getName, StepConfiguration::getValue));
		stepProcessor.initialize(configMap);
		return stepProcessor;
	}

	//TODO inject with Guice
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
