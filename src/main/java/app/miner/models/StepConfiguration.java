package app.miner.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.BelongsTo;
import org.javalite.activejdbc.annotations.Table;

@Table("step_configurations")
@BelongsTo(parent = Step.class, foreignKeyName = "step_id")
public class StepConfiguration extends Model {


    public String getName() {
        return getString("name");
    }

    public Object getValue() {
        return get("value");
    }

}
