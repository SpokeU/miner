package app.miner.module.step;


import app.miner.api.StepProcessor;
import com.google.inject.Injector;

import java.util.Map;

public abstract class AbstractStepProcessor implements StepProcessor {

    protected Injector injector;

    @Override
    public Map<String, Object> preProcess(Map<String, Object> data) { return data; }

    @Override
    public Map<String, Object> postProcess(Map<String, Object> data) {
        return data;
    }

}
