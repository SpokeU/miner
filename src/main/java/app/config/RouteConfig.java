package app.config;

import app.controllers.ProjectsController;
import org.javalite.activeweb.AbstractRouteConfig;
import org.javalite.activeweb.AppContext;

/**
 * Created by Issen on 29.11.2015.
 */
public class RouteConfig extends AbstractRouteConfig{
    @Override
    public void init(AppContext appContext) {
        route("/projects/new_form").get().to(ProjectsController.class).action("newForm");
        route("/projects/{id}").get().to(ProjectsController.class).action("view");
        route("/projects/editForm/{id}").get().to(ProjectsController.class).action("editForm");

        route("/projects").post().to(ProjectsController.class).action("create");
        route("/projects/{id}").get().to(ProjectsController.class).action("view");
        route("/projects/update").get().to(ProjectsController.class).action("update");
        route("/projects/delete/{id}").get().to(ProjectsController.class).action("delete");
        route("/projects").get().to(ProjectsController.class);

    }
}
