package app.parser;


import java.util.HashMap;
import java.util.Map;

public abstract class BaseStep implements IStep {

    Map<String, Object> pluginConfig = new HashMap<>();

    @Override
    public Map<String, Object> preProcess(Map<String, Object> data) { return data; }

    @Override
    public Map<String, Object> postProcess(Map<String, Object> data) {
        return data;
    }

    @Override
    public Map<String, Object> config() {
        return pluginConfig;
    }

    @Override
    public void setConfig(Map<String, Object> config) {
        pluginConfig = config;
    }
}
