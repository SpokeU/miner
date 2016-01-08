package app.miner.module.step;

import app.miner.api.StepConfigurator;

import java.util.Map;
import java.util.stream.Collectors;

public abstract class AbstractStepConfigurator implements StepConfigurator {

    @Override
    public void populateViewParameters(Map<String, String> viewParams) {

    }

    @Override
    public void populateEditParameters(Map<String, String> editParams) {

    }

    @Override
    public void populateCreateParameters(Map<String, String> createParams) {

    }

    @Override
    public Map<String, String> onSave(Map<String, String[]> params) {
        Map<String, String> paramsToSave = params.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue()[0]));
        return paramsToSave;
    }
}
