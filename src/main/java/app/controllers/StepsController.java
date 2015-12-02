package app.controllers;

import app.parser.Modules;
import app.parser.step.StepTemplateRenderer;
import org.javalite.activeweb.AppController;
import org.javalite.common.Inflector;

public class StepsController extends AppController{

    public void editForm(){

    }

    public void newForm() throws Exception {
    	new StepTemplateRenderer().renderTemplate("view", "get_page");
        view("steps", Modules.steps);
    }

    public void stepConfigForm(){
        String stepKey = param("step_key");
        String formType = param("formType");
        String configuratorClass = Inflector.camelize(stepKey, true) + "Configurator";
        if(formType.equals("create")){

        }
    }
    
    public void getStepConfigurationTemplate() throws Exception {
    	String viewType = param("view_type");//view type
        String stepKey = param("step_key");//module_key
        respond(new StepTemplateRenderer().renderTemplate(viewType, stepKey));
    }

}
