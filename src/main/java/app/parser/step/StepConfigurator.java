package app.parser.step;

import java.util.Map;

public interface StepConfigurator {

    Class processorClass();

    void populateViewParameters(Map<String, String> viewParams);

    void populateEditParameters(Map<String, String> editParams);

    void populateCreateParameters(Map<String, String> createParams);

}
