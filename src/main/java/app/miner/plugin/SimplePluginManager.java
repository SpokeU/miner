package app.miner.plugin;

import app.guice.AppInjector;
import app.miner.api.StepProcessor;
import com.google.common.collect.Maps;
import com.google.inject.Guice;

import javax.inject.Singleton;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

@Singleton
public class SimplePluginManager {

    public void loadPlugins() throws IOException {

        //load jar
        //parse plugin.json
        //validate
        //load classes
        //add to modules
    }

    public void loadPlugin() throws IOException, ClassNotFoundException {
        String pluginPath = "D:\\Development\\JAVA\\Projects\\miner\\plugins\\simpleplugin-1.0-SNAPSHOT.jar";
        URL[] urls = {new URL("jar:file:" + pluginPath + "!/")};
        URLClassLoader cl = URLClassLoader.newInstance(urls, getClass().getClassLoader());
        JarFile jar = new JarFile(pluginPath);
        Enumeration e = jar.entries();
        while (e.hasMoreElements()) {
            JarEntry je = (JarEntry) e.nextElement();
            if (je.isDirectory() || !je.getName().endsWith(".class")) {
                continue;
            }

            String className = je.getName().substring(0, je.getName().length() - 6);
            className = className.replace('/', '.');
            Class c = cl.loadClass(className);
        }

        Class<StepProcessor> stepConfiguratorClass = (Class<StepProcessor>) Class.forName("com.miner.step.processors.SimpleStepProcessor", true, cl).asSubclass(StepProcessor.class);;
        StepProcessor conf = Guice.createInjector(new AppInjector()).getInstance(stepConfiguratorClass);
        conf.processStep(Maps.newHashMap());
    }

}
