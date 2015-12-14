package app.miner.plugin;

import java.util.Map;

import org.json.simple.JSONObject;

import com.google.common.collect.Maps;
/**
 * This class represents single module config
 * {
      "name":"Element Iterator",
      "key":"element_iterator"
    }
 */
public class ModuleConfig {
	
	public static String KEY = "key";
    public static String NAME = "name";
    public static String PROCESSOR_CLASS = "processor_class";
    public static String CONFIGURATOR_CLASS = "configurator_class";
    public static String VIEW_TEMPLATE = "view_template";
    public static String EDIT_TEMPLATE = "edit_template";
    public static String CREATE_TEMPLATE = "create_template";

    private Map<String, Object> config = Maps.newHashMap();
    
    public String key(){
    	return getString(KEY);
    }

    public ModuleConfig(JSONObject jsonConfig) {
        config = jsonConfig;
    }

    public String getString(String key) {
        return get(key) != null ? get(key).toString() : null;
    }

    public Object get(String key) {
        return config.get(key);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ModuleConfig)) return false;

        ModuleConfig that = (ModuleConfig) o;

        if (!config.equals(that.config)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return config.hashCode();
    }

	@Override
	public String toString() {
		return config.toString();
	}
    
    
}
