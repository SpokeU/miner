package app.miner.module;

import app.guice.AppInjector;
import app.miner.AppConfig;
import app.miner.plugin.Plugins;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Guice;
import com.google.inject.Injector;

import java.util.List;
import java.util.stream.Collectors;

public class Modules {

	private Modules(){}

	public static List<Module> all() {
		List<Module> pluginModules = Plugins.all().stream().flatMap(p -> p.getModules().stream()).collect(Collectors.toList());
		return Lists.newArrayList(Iterables.concat(pluginModules, AppConfig.getModules()));
	}

	/**
	 * returns all modules of provided type
	 */
	public static List<Module> forType(ModuleType moduleType) {
		List<Module> pluginModules = Plugins.all().stream().flatMap(p -> p.getModules(moduleType).stream())
				.collect(Collectors.toList());

		List<Module> appModules = AppConfig.getModules().stream().filter(m -> m.getModuleType().equals(moduleType))
				.collect(Collectors.toList());
		return Lists.newArrayList(Iterables.concat(pluginModules, appModules));
	}

	public static Module forKey(String moduleKey) {
		return all().stream().filter(m -> m.getKey().equals(moduleKey)).findFirst().orElse(null);
	}

	//TODO create injector and save it in context
	public Injector injector(){
		return Guice.createInjector(new AppInjector());
	}
}
