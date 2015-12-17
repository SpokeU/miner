package app.miner.module;

import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

import app.miner.plugin.Plugins;

public enum ModuleType {
	STEP();

	public List<ModuleConfig> all() {
		URL appConfig = ModuleType.class.getClassLoader().getResource("modules.json");
		List<ModuleConfig> builtInModules = ConfigParser.getModules(appConfig);
		List<ModuleConfig> pluginModules = Plugins.all().stream().flatMap(p -> p.getModules(this).stream())
				.collect(Collectors.toList());
		builtInModules.addAll(pluginModules); // TODO fix this shit
		return builtInModules;
	}

	public ModuleConfig get(String key) {
		return all().stream().filter(m -> m.getKey().equals(key)).findFirst().orElse(null);
	}
}
