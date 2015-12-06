package app.miner;

import com.google.common.collect.Maps;
import org.json.simple.JSONObject;

import java.util.List;
import java.util.Map;

/**
 * Created by Issen on 06.12.2015.
 */
public abstract class ModuleConfig {

    private Map<String, Object> config = Maps.newHashMap();

    public ModuleConfig(JSONObject jsonConfig) {
        keys().forEach(key -> {
            config.put(key, jsonConfig.get(key));
        });
    }

    public String getString(String key) {
        return get(key) != null ? get(key).toString() : null;
    }

    public Object get(String key) {
        return config.get(key);
    }

    public abstract List<String> keys();

}
