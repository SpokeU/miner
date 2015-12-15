package app.controllers;

import java.util.Map;

import org.javalite.activeweb.AppController;
import org.javalite.activeweb.annotations.POST;

import app.miner.api.StepConfigurator;
import app.miner.module.ModuleType;
import app.miner.step.StepTemplateRenderer;

public class StepsController extends AppController{

    public void editForm(){

    }

    public void newForm() throws Exception {
    	new StepTemplateRenderer().renderTemplate("view", "get_page");
        view("steps", ModuleType.STEP.all());
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
