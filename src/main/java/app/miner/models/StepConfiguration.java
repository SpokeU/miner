package app.miner.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.BelongsTo;
import org.javalite.activejdbc.annotations.Table;

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

    /**
     * Saves step config from provided map
     *
     * @param map
     * @return
     */
    public static void saveConfig(Long stepId, Map<String, String> map) {
        //TODO implement
        map.forEach((name, value) -> {
            System.out.print(name + ":" + value);
        });
    }

}
