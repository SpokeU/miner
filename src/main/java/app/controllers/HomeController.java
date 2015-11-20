package app.controllers;

import org.javalite.activeweb.AppController;
import org.javalite.activeweb.annotations.GET;

public class HomeController extends AppController {
    public void index(){}

    @GET
    public void createStep(){
        redirect(HomeController.class);
    }
}
