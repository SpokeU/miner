package app.miner.plugin;

import org.json.simple.JSONObject;

import java.util.Arrays;
import java.util.List;

public class StepConfig extends ModuleConfig{

    public static String KEY = "key";
    public static String NAME = "name";
    public static String PROCESSOR_CLASS = "processor_class";
    public static String CONFIGURATOR_CLASS = "configurator_class";
    public static String VIEW_TEMPLATE = "view_template";
    public static String EDIT_TEMPLATE = "edit_template";
    public static String CREATE_TEMPLATE = "create_template";

    public StepConfig(JSONObject jsonConfig) {
        super(jsonConfig);
    }

    public List<String> keys() {
        return Arrays.asList(KEY, NAME, PROCESSOR_CLASS, CONFIGURATOR_CLASS, VIEW_TEMPLATE, EDIT_TEMPLATE, CREATE_TEMPLATE);
    }
}
