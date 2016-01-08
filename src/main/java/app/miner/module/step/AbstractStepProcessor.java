package app.miner.module.step;


import app.miner.api.StepProcessor;

import java.util.Map;

public abstract class AbstractStepProcessor implements StepProcessor {

    @Override
    public Map<String, Object> preProcess(Map<String, Object> data) { return data; }

    @Override
    public Map<String, Object> postProcess(Map<String, Object> data) {
        return data;
    }

}
