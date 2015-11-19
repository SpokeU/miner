package app.parser.models;

import com.google.common.collect.Lists;
import org.javalite.activejdbc.Model;

import java.util.List;

/**
 * Created by Issen on 18.11.2015.
 */
public class Step extends Model {

    public static final String build_id = "build_id";

    public Long id;
    public String name;
    public String description;
    public String clazz;
    public Integer order;

    public String getClazz(){
        return getString("clazz");
    }

    public List<StepConfig> getConfig(){
        return Lists.newArrayList();
    }

    public static List<Step> findStepsForJob() {
        return Lists.newArrayList();
    }
}
