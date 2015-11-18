package app.parser;

import app.parser.models.Step;

import java.util.List;

/**
 * Created by Issen on 18.11.2015.
 */
public class ParserManager {

    public void executeJob(Long buildId){
        List<Step> steps = Step.where(Step.build_id + " = ? order by order", buildId);
    }

}
