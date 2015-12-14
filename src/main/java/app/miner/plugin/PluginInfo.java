package app.miner.plugin;

import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.common.collect.Sets;

import app.miner.Modules;

public class PluginInfo {

	private String key;
	private String name;
	private String basePackage;

	private ClassLoader pluginClassLoader;
	private Set<ModuleConfig> modules = Sets.newConcurrentHashSet();

	public PluginInfo(ClassLoader pluginClassLoader, String pluginDescriptor) {
		this.pluginClassLoader = pluginClassLoader;
	}

	public PluginInfo(ClassLoader pluginClassLoader, JSONObject pluginDescriptor) {
		this.pluginClassLoader = pluginClassLoader;
		initPluginProperties(pluginDescriptor);
		initModules(pluginDescriptor);
	}

	private void initPluginProperties(JSONObject pluginDescriptor) {
		key = (String) pluginDescriptor.get("key");
		name = (String) pluginDescriptor.get("name");
		basePackage = (String) pluginDescriptor.get("basePackage");
	}

	private void initModules(JSONObject pluginDescriptor) {
		for(Modules m: Modules.values()){
			JSONArray pluginModules = (JSONArray) pluginDescriptor.get(m.name().toLowerCase());
			if(pluginModules != null){
				pluginModules.forEach(s -> modules.add(new ModuleConfig((JSONObject) s)));
			}
		}
	}

	public String getKey() {
		return key;
	}

	public String getName() {
		return name;
	}

	public String getBasePackage() {
		return basePackage;
	}

	public ClassLoader getPluginClassLoader() {
		return pluginClassLoader;
	}

	public Set<ModuleConfig> getModules() {
		return modules;
	}

	@Override
	public String toString() {
		return "PluginInfo [key=" + key + ", name=" + name + ", basePackage=" + basePackage + ", pluginClassLoader="
				+ pluginClassLoader + ", modules=" + modules + "]";
	}
	
	

}
