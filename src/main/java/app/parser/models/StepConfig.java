package app.parser.models;

import org.javalite.activejdbc.Model;

/**
 * Created by Issen on 18.11.2015.
 */
public class StepConfig extends Model {

    //id, description, name, value

    public String getName() {
        return getString("name");
    }

    public Object getValue() {
        return get("value");
    }

}
