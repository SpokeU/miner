package app.miner.plugin;

import com.google.common.collect.Maps;
import org.apache.commons.io.IOUtils;
import org.json.simple.parser.ParseException;

import javax.inject.Singleton;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Singleton
public class SimplePluginManager {

    public static String PLUGINS_DIRECTORY = "plugins";

    private Map<String, ClassLoader> pluginClassLoaders = Maps.newConcurrentMap();

    public void loadPlugins() throws IOException, ParseException {
        for (File pluginJar: getPluginFiles()){
            loadPlugin(pluginJar);
        }
    }

    public void loadPlugin(File pluginJar) throws IOException, ParseException {
        URLClassLoader pluginCl = createClassLoaderForPlugin(pluginJar);
        String pluginDescriptor = IOUtils.toString(pluginCl.getResourceAsStream("plugin.json"), "UTF-8");
    }

    public URLClassLoader createClassLoaderForPlugin(File pluginFile){
        URLClassLoader pluginCl = null;
        try {
            URL jarUrl = pluginFile.toURI().toURL();
            pluginCl = URLClassLoader.newInstance(new URL[]{jarUrl}, getClass().getClassLoader());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return pluginCl;
    }

    public List<File> getPluginFiles() {
        File pluginsDir = new File(PLUGINS_DIRECTORY);
        return Arrays.asList(pluginsDir.listFiles((dir, name) -> name.endsWith("jar")));
    }

}
