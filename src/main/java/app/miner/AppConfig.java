package app.miner;

import java.net.URL;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;

import app.miner.module.AppJsonParser;
import app.miner.module.ModuleConfig;
import app.miner.module.ModuleType;

public class AppConfig {

	public static final String CONFIG_FILE = "appConfig.json";

	private static List<ModuleConfig> builtInModules = Lists.newArrayList();

	static {
		URL appConfig = ModuleType.class.getClassLoader().getResource(CONFIG_FILE);
		builtInModules = Collections.unmodifiableList(AppJsonParser.getModules(appConfig));
	}

	public static List<ModuleConfig> getModules() {
		return builtInModules;
	}

}
