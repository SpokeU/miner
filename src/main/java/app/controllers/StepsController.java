package app.controllers;

import app.parser.Modules;
import app.parser.step.StepTemplateRenderer;

import java.lang.reflect.InvocationTargetException;

import org.javalite.activeweb.AppController;
import org.javalite.common.Inflector;

public class StepsController extends AppController{

    public void editForm(){

    }

    public void newForm() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
    	new StepTemplateRenderer().renderTempalte("view", "get_page");
        view("steps", Modules.steps);
    }

    public void stepConfigForm(){
        String stepKey = param("step_key");
        String formType = param("formType");
        String configuratorClass = Inflector.camelize(stepKey, true) + "Configurator";
        if(formType.equals("create")){

        }
    }
    
    public void getStepConfigurationTemplate() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
    	respond(new StepTemplateRenderer().renderTempalte("view", "get_page"));
    }

}
