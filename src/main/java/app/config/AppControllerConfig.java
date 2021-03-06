package app.config;

import app.controllers.*;
import org.javalite.activeweb.AbstractControllerConfig;
import org.javalite.activeweb.AppContext;
import org.javalite.activeweb.controller_filters.DBConnectionFilter;
import org.javalite.activeweb.controller_filters.TimingFilter;

public class AppControllerConfig extends AbstractControllerConfig {

    public void init(AppContext context) {
        addGlobalFilters(new TimingFilter());
        add(new DBConnectionFilter()).to(HomeController.class, TestController.class, ProjectsController.class, JobsController.class, StepsController.class);
    }
}
