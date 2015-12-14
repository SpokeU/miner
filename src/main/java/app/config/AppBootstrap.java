package app.config;

import org.javalite.activeweb.AppContext;
import org.javalite.activeweb.Bootstrap;

import com.google.inject.Guice;

import app.guice.AppInjector;

public class AppBootstrap extends Bootstrap {
    public void init(AppContext context) {
        setInjector(Guice.createInjector(new AppInjector()));
        //ModulesOld.init();
    }
}
