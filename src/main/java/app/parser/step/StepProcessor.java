package app.parser.step;

import java.util.Map;

/**
 * Created by Issen on 20.11.2015.
 */
public interface StepProcessor {

    public void initialize(Map<String, Object> config);

    public Map<String, Object> processStep(Map<String, Object> data);

    public Map<String, Object> preProcess(Map<String, Object> data);

    public Map<String, Object> postProcess(Map<String, Object> data);
}
