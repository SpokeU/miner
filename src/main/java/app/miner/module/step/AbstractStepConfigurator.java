package app.miner.module.step;

import app.miner.api.StepConfigurator;

import java.util.Map;

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
}
