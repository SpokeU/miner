package app.miner.plugin;

import java.util.List;
import java.util.stream.Collectors;

import org.json.simple.JSONObject;

import com.google.common.collect.Lists;

import app.miner.module.ConfigParser;
import app.miner.module.ModuleConfig;
import app.miner.module.ModuleType;

public class PluginInfo {

	private String key;
	private String name;
	private String basePackage;

	private ClassLoader pluginClassLoader;
	private List<ModuleConfig> modules = Lists.newArrayList();

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
		modules = ConfigParser.getModules(pluginDescriptor);
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

	public List<ModuleConfig> getModules() {
		return modules;
	}

	public List<ModuleConfig> getModules(ModuleType moduleType) {
		return modules.stream().filter(module -> module.getModuleType().equals(moduleType))
				.collect(Collectors.toList());
	}

	public List<ModuleConfig> steps() {
		return modules.stream().filter(m -> m.getModuleType().equals(ModuleType.STEP)).collect(Collectors.toList());
	}

	@Override
	public String toString() {
		return "PluginInfo [key=" + key + ", name=" + name + ", basePackage=" + basePackage + ", pluginClassLoader="
				+ pluginClassLoader + ", modules=" + modules + "]";
	}

}
