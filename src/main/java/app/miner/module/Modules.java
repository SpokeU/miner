package app.miner.module;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Singleton;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import app.miner.AppConfig;
import app.miner.plugin.Plugins;

@Singleton
public class Modules {

	public List<ModuleConfig> all() {
		List<ModuleConfig> pluginModules = Plugins.all().stream().flatMap(p -> p.getModules().stream()).collect(Collectors.toList());
		return Lists.newArrayList(Iterables.concat(pluginModules, AppConfig.getModules()));
	}

	/**
	 * returns all modules of provided type
	 */
	public List<ModuleConfig> forType(ModuleType moduleType) {
		List<ModuleConfig> pluginModules = Plugins.all().stream().flatMap(p -> p.getModules(moduleType).stream())
				.collect(Collectors.toList());

		List<ModuleConfig> appModules = AppConfig.getModules().stream().filter(m -> m.getModuleType().equals(moduleType))
				.collect(Collectors.toList());
		return Lists.newArrayList(Iterables.concat(pluginModules, appModules));
	}

	public ModuleConfig forKey(String moduleKey) {
		return null;
	}
}
