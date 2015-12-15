package app.controllers;

import app.miner.plugin.Plugins;
import org.javalite.activeweb.AppController;
import org.javalite.activeweb.FormItem;
import org.javalite.activeweb.annotations.POST;

import java.util.List;

public class AdminController extends AppController {

    public void index() {
    }

    public void plugins() {
        view("plugins", Plugins.all());
    }

    @POST
    public void uploadPlugin() {
        List<FormItem> items = multipartFormItems();
        for (FormItem item : items) {
            System.out.println(item.getFileName());
        }
    }

    @Override
    protected String getLayout() {
        return "/layouts/admin_layout";
    }
}
