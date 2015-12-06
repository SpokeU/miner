package app.miner.step;

import app.miner.api.StepProcessor;
import com.google.common.collect.Maps;

import javax.inject.Singleton;
import java.util.List;
import java.util.Map;

@Singleton
public class StepProcessorExecutor {

    public void processSteps(List<? extends StepProcessor> stepProcessors){
        Map<String, Object> processData = Maps.newHashMap();
        for (StepProcessor stepProcessor : stepProcessors) {
            processData = processStep(stepProcessor, processData);
        }
    }

    public Map<String, Object> processStep(StepProcessor step, Map<String, Object> data){
        Map<String, Object> preProcessData = step.preProcess(data);
        Map<String, Object> processData = step.processStep(preProcessData);
        return step.postProcess(data);
    }
}
