package app.config;

import app.guice.AppInjector;
import app.miner.plugin.SimplePluginManager;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.javalite.activeweb.AppContext;
import org.javalite.activeweb.Bootstrap;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class AppBootstrap extends Bootstrap {

    private Injector injector;

    public void init(AppContext context) {
        injector = Guice.createInjector(new AppInjector());
        setInjector(injector);

        try {
            injector.getInstance(SimplePluginManager.class).loadPlugins();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
