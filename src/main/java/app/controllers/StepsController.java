package app.controllers;

import app.miner.api.StepConfigurator;
import app.miner.models.Step;
import app.miner.module.ModuleType;
import app.miner.module.Modules;
import app.miner.module.step.StepTemplateRenderer;
import org.javalite.activeweb.AppController;
import org.javalite.activeweb.annotations.POST;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

public class StepsController extends AppController{
	
	@Inject
	Modules modules;

    @Inject
    StepTemplateRenderer templateRendered;

    public void index(){
        param("id");
    }

    public void editSteps(){
        String jobId = param("jobId");
        List<Step> steps = Step.where("job_id=?", Long.valueOf(jobId));
        view("steps", steps);
        view("jobId", param("jobId"));
        view("sidebar", "edit_job_nav.ftl");
    }

    public void editForm(){

    }

    public void createStep() throws Exception {
        view("steps", modules.forType(ModuleType.STEP));
    }
    
    public void getStepConfigurationTemplate() throws Exception {
        System.out.println("rendering");
    	String viewType = param("view_type");//create,edit,view
        String stepKey = param("step_key");//module_key
        respond(templateRendered.renderTemplate(viewType, stepKey));
    }
    
    @POST
    public void saveStepConfiguration() throws Exception{
    	String stepKey = param("step_key");
    	StepConfigurator configurator = new StepTemplateRenderer().getConfigurator(stepKey);
    	Map<String, String> paramsToSave = configurator.onSave(params());
    	//transform map to List<StepConfiguration>
    }

}
