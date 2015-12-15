package app.miner.plugin;

import java.util.List;
import java.util.Set;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class Plugins {

	private static Set<PluginInfo> plugins = Sets.newConcurrentHashSet();

	public static List<PluginInfo> all() {
		return Lists.newArrayList(plugins);
	}

	public static void add(PluginInfo plugin) {
		if (!plugins.contains(plugin)) {
			plugins.add(plugin);
		}
	}

	public static PluginInfo get(String key) {
		return plugins.stream().filter(p -> p.getKey().equals(key)).findFirst().orElseGet(null);
	}

}
