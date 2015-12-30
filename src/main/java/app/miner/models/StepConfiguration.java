package app.miner.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.BelongsTo;
import org.javalite.activejdbc.annotations.Table;

import java.util.List;
import java.util.Map;

@Table("step_configurations")
@BelongsTo(parent = Step.class, foreignKeyName = "step_id")
public class StepConfiguration extends Model {

    public String getName() {
        return getString("name");
    }

    public Object getValue() {
        return get("value");
    }

    public static List<StepConfiguration> fromInputParams(Map<String, String> map){
        //TODO implement
        map.forEach((name, value) -> {System.out.print(name + ":" + value);});
        return null;
    }

}
