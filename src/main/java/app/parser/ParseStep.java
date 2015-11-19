package app.parser;


import java.util.Map;

public interface ParseStep {

    public void initialize(Map<String, Object> config);

    public Map<String, Object> processStep(Map<String, Object> data);

    public Map<String, Object> preProcess(Map<String, Object> data);

    public Map<String, Object> postProcess(Map<String, Object> data);
}
