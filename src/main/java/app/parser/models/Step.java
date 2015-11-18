package app.parser.models;

import org.javalite.activejdbc.Model;

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

}
