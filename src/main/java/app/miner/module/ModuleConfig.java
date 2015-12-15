package app.miner.module;

import java.util.Map;

import org.json.simple.JSONObject;

import com.google.common.collect.Maps;

/**
 * This class represents single module config 
 * { "name":"Element Iterator",
 * "key":"element_iterator" }
 */
public class ModuleConfig {

	public static String KEY = "key";

	private ModuleType moduleType;
	private Map<String, Object> config = Maps.newHashMap();

	public String key() {
		return getProperty(KEY);
	}

	public ModuleConfig(JSONObject jsonConfig, ModuleType m) {
		config = jsonConfig;//TODO check this
		this.moduleType = m;
	}

	public String getProperty(String key) {
		return get(key) != null ? get(key).toString() : null;
	}

	public Object get(String key) {
		return config.get(key);
	}

	public ModuleType getModuleType() {
		return moduleType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((config == null) ? 0 : config.hashCode());
		result = prime * result + ((moduleType == null) ? 0 : moduleType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModuleConfig other = (ModuleConfig) obj;
		if (config == null) {
			if (other.config != null)
				return false;
		} else if (!config.equals(other.config))
			return false;
		if (moduleType != other.moduleType)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ModuleConfig [moduleType=" + moduleType + ", config=" + config + "]";
	}
}
