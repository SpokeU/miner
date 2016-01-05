package app.miner.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.BelongsTo;
import org.javalite.activejdbc.annotations.Table;

import java.util.Map;

@Table("step_configurations")
@BelongsTo(parent = Step.class, foreignKeyName = "step_id")
public class StepConfiguration extends Model {

    public enum fields{name, value, step_id}


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
        map.forEach((name, value) -> {
            StepConfiguration stepConfig = new StepConfiguration();
            stepConfig.set("name", name);
            stepConfig.set("value", value);
            stepConfig.set("step_id", stepId);
            stepConfig.saveIt();
        });
    }

}
