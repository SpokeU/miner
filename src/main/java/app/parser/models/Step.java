package app.parser.models;

import org.javalite.activejdbc.Model;

import java.util.List;

public class Step extends Model {

    public static final String parse_job_id = "parse_job_id";

    public Long id;
    public String name;
    public String description;
    public String clazz;
    public Integer order;

    public String getClazz(){
        return getString("clazz");
    }

    public List<StepConfiguration> getConfig(){
        return getAll(StepConfiguration.class);
    }

    public static List<Step> findStepsForJob(Long jobId) {
        return Step.where(Step.parse_job_id + " = ? order by step_order", jobId).include(StepConfiguration.class);
    }
}
