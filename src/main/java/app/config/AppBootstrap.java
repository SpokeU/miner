package app.config;

import app.guice.AppInjector;
import com.google.inject.Guice;
import org.javalite.activeweb.AppContext;
import org.javalite.activeweb.Bootstrap;

public class AppBootstrap extends Bootstrap {
    public void init(AppContext context) {
        setInjector(Guice.createInjector(new AppInjector()));
    }
}
