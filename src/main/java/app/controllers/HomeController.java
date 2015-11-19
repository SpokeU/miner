package app.controllers;

import app.parser.models.Step;
import org.javalite.activeweb.AppController;
import org.javalite.activeweb.annotations.GET;

public class HomeController extends AppController {
    public void index(){}

    @GET
    public void createStep(){
        Step step = Step.create("name", "Get main page", "description", "...", "clazz", "app.parser.step.GetPage", "step_order", 0);
        if(step.save()){
            System.out.println("Saved successfully");
        }else{
            System.out.println(step.errors());
        }
        redirect(HomeController.class);
    }
}
