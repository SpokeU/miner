package app.miner.plugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.List;

import javax.inject.Singleton;

import org.apache.commons.io.IOUtils;
import org.javalite.common.Util;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@Singleton
public class SimplePluginManager {

    public static String PLUGINS_DIRECTORY = "plugins";
    
    private JSONParser parser = new JSONParser();

    public void loadPlugins() throws IOException, ParseException {
        for (File pluginJar: getPluginFiles()){
            loadPlugin(pluginJar);
        }
    }

    public void loadPlugin(File pluginJar) throws IOException, ParseException {
        URLClassLoader pluginCl = createClassLoaderForPlugin(pluginJar);
        String pluginDescriptor = IOUtils.toString(pluginCl.getResourceAsStream("plugin.json"), "UTF-8");
        JSONObject pluginDescriptorJson = (JSONObject) parser.parse(pluginDescriptor);
        //validate plugin
        	//check key presence
        Plugins.add(new PluginInfo(pluginCl, pluginDescriptorJson));
    }
    
    public void uploadPlugin(String pluginName, InputStream in) throws IOException, ParseException{
    	Util.saveTo(new File(PLUGINS_DIRECTORY).getAbsolutePath() + File.separator + pluginName , in);
    	loadPlugins();
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

    /**
     * returns all files with .jar extension in PLUGINS_DIRECTORY folder.
     * See appConfig.json for PLUGINS_DIRECTORY property
     */
    public List<File> getPluginFiles() {
        File pluginsDir = new File(PLUGINS_DIRECTORY);
        return Arrays.asList(pluginsDir.listFiles((dir, name) -> name.endsWith("jar")));
    }

}
