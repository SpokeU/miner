package app.parser.step;

import java.util.Map;

public interface StepConfigurator {

    void populateViewParameters(Map<String, String> viewParams);

    void populateEditParameters(Map<String, String> editParams);

    void populateCreateParameters(Map<String, String> createParams);
    
    Map<String, String> onSave(Map<String, String[]> params);

}
