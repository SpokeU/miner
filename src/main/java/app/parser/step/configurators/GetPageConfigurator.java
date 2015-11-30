package app.parser.step.configurators;

import app.parser.step.StepConfigurator;
import app.parser.step.processors.GetPage;

import java.util.Map;

public class GetPageConfigurator implements StepConfigurator{

    @Override
    public Class processorClass() {
        return GetPage.class;
    }

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
