package app.miner.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.BelongsTo;

@BelongsTo(parent = Project.class, foreignKeyName = "project_id")
public class Job extends Model{

}
