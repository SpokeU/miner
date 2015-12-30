package app.miner.models;

import app.miner.api.StepConfigurator;
import app.miner.module.step.StepConfiguratorFactory;
import org.javalite.activejdbc.Model;

import java.util.List;
import java.util.Map;

/**
 * Trying to implement rich data model
 */
public class Step extends Model {

    public static final String parse_job_id = "job_id";


    /*========= Field getters ========= */
    public String getClazz(){
        return getString("clazz");
    }

    /*========= DAO methods ========= */
    public List<StepConfiguration> getConfig(){
        return getAll(StepConfiguration.class);
    }

    public static List<Step> findStepsForJob(Long jobId) {
        return Step.where(Step.parse_job_id + " = ? order by step_order", jobId).include(StepConfiguration.class);
    }

    /* Business login methods */

    /**
    Gets step_key, name, description, order and saves it to "steps" Table
    The rest of the params passes to StepConfigurator onSave callback and then saved to step_configurations table
    */
    public static void saveStep(Map<String, String[]> stepForm){
        String stepKey = stepForm.remove("step_key")[0];
        String stepName = stepForm.remove("name")[0];
        String stepDescription = stepForm.remove("description")[0];

        //save step with those
        StepConfigurator configurator = StepConfiguratorFactory.forKey(stepKey);
        Map<String, String> configToSave = configurator.onSave(stepForm);
        StepConfiguration.fromInputParams(configToSave);
        //StepConfigurator.forKey
    }
}
