package app.controllers;

import app.parser.Modules;
import org.javalite.activeweb.AppController;
import org.javalite.common.Inflector;

public class StepsController extends AppController{

    public void editForm(){

    }

    public void newForm(){
        view("steps", Modules.steps);
    }

    public void stepConfigForm(){
        String stepKey = param("step_key");
        String formType = param("formType");
        String configuratorClass = Inflector.camelize(stepKey, true) + "Configurator";
        if(formType.equals("create")){

        }
    }

}
