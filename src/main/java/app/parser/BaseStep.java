package app.parser;


import com.google.inject.Injector;

import java.util.Map;

public abstract class BaseStep implements ParseStep {

    protected Injector injector;

    @Override
    public Map<String, Object> preProcess(Map<String, Object> data) { return data; }

    @Override
    public Map<String, Object> postProcess(Map<String, Object> data) {
        return data;
    }

}
