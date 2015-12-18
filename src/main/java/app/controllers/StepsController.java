package app.controllers;

import java.util.Map;

import javax.inject.Inject;

import org.javalite.activeweb.AppController;
import org.javalite.activeweb.annotations.POST;

import app.miner.api.StepConfigurator;
import app.miner.module.ModuleType;
import app.miner.module.Modules;
import app.miner.module.step.StepTemplateRenderer;

public class StepsController extends AppController{
	
	@Inject
	Modules modules;

    public void editForm(){

    }

    public void newForm() throws Exception {
        view("steps", modules.forType(ModuleType.STEP));
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
