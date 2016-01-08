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

    public static final String job_id = "job_id";


    /*========= Field getters ========= */
    public String getKey() {
        return getString("step_key");
    }

    /*========= DAO methods ========= */
    public List<StepConfiguration> getConfig() {
        return getAll(StepConfiguration.class);
    }

    public static List<Step> findStepsForJob(Long jobId) {
        return Step.where(job_id + " = ? order by step_order", jobId).include(StepConfiguration.class);
    }

    /*========= Business login methods ========= */

    /**
     * Gets step_key, name, description, order and saves it to "steps" Table
     * The rest of the params passes to StepConfigurator onSave callback and then saved to step_configurations table
     */
    public static void createStep(Map<String, String[]> stepForm) {
        String stepName = stepForm.remove("name")[0];
        String stepDescription = stepForm.remove("description")[0];
        String stepKey = stepForm.remove("step_key")[0];
        Long jobId = Long.valueOf(stepForm.remove("job_id")[0]);
        Long stepOrder = generateNextStepOrder(jobId);

        Step step = new Step();
        step.set("step_key", stepKey).set("name", stepName).set("description", stepDescription).set("job_id", jobId).set("step_order", stepOrder).save();

        StepConfigurator configurator = StepConfiguratorFactory.forKey(stepKey);
        Map<String, String> configToSave = configurator.onSave(stepForm);
        StepConfiguration.saveConfig(step.getLongId(), configToSave);
    }

    /**
     *
     * @param jobId
     * @return Next step order for job
     * For instance:
     * If job contains two steps with 1 and 2 order. Then it will return 3
     */
    private static Long generateNextStepOrder(Long jobId){
        Step lastStep = Step.findFirst(job_id + " = ? order by step_order DESC", jobId); //FIND LAST STEP
        if(lastStep == null){
            return 1l;
        }
        return lastStep.getLong("step_order") + 1;
    }
}
