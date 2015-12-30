package app.miner;

import app.miner.module.ConfigParser;
import app.miner.module.Module;
import app.miner.module.ModuleType;
import com.google.common.collect.Lists;

import java.net.URL;
import java.util.Collections;
import java.util.List;

public class AppConfig {

	public static final String CONFIG_FILE = "appConfig.json";

	private static List<Module> builtInModules = Lists.newArrayList();

	static {
		URL appConfig = ModuleType.class.getClassLoader().getResource(CONFIG_FILE);
		builtInModules = Collections.unmodifiableList(ConfigParser.getModules(appConfig));
	}

	public static List<Module> getModules() {
		return builtInModules;
	}

}
