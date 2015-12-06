package app.controllers;

import app.miner.Modules;
import app.miner.api.StepConfigurator;
import app.miner.step.StepTemplateRenderer;
import org.javalite.activeweb.AppController;
import org.javalite.activeweb.annotations.POST;

import java.util.Map;

public class StepsController extends AppController{

    public void editForm(){

    }

    public void newForm() throws Exception {
    	new StepTemplateRenderer().renderTemplate("view", "get_page");
        view("steps", Modules.steps);
    }
    
    public void getStepConfigurationTemplate() throws Exception {
    	String viewType = param("view_type");//view type
        String stepKey = param("step_key");//module_key
        respond(new StepTemplateRenderer().renderTemplate(viewType, stepKey));
    }
    
    @POST
    public void saveStepConfiguration() throws Exception{
    	String stepKey = param("step_key");
    	StepConfigurator configurator = new StepTemplateRenderer().getConfigurator(stepKey);
    	Map<String, String> paramsToSave = configurator.onSave(params());
    	//transform map to List<StepConfiguration>
    }

}
