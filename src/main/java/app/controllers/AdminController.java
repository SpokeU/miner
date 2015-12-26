package app.controllers;

import app.miner.plugin.Plugins;
import app.miner.plugin.SimplePluginManager;
import org.javalite.activeweb.AppController;
import org.javalite.activeweb.FormItem;
import org.javalite.activeweb.annotations.POST;

import javax.inject.Inject;
import java.util.List;

public class AdminController extends AppController {
	
	@Inject
	private SimplePluginManager pluginManager;

    public void index() {
        view("sidebar", "admin_nav.ftl");
    }

    public void plugins() {
        view("plugins", Plugins.all());
        view("sidebar", "admin_nav.ftl");
    }

    @POST
    public void uploadPlugin() throws Exception {
        List<FormItem> items = multipartFormItems();
        for (FormItem item : items) {
            pluginManager.uploadPlugin(item.getName(), item.getInputStream());
        }
        redirect(AdminController.class);
    }
}
