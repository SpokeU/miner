package app.miner.plugin;

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
}
