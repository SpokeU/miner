package app.miner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Modules {

    private static JSONParser parser = new JSONParser();

    public static List<ModuleConfig> steps = new ArrayList<>();

    public static Function<JSONObject, StepConfig> transformStepJson = stepJson -> {
        return new StepConfig(stepJson);
    };

    public static void init() {
        File modulesFile = new File(Modules.class.getClassLoader().getResource("modules.json").getFile());
        try {
            JSONObject modulesJson = (JSONObject) parser.parse(new FileReader(modulesFile));
            JSONArray stepsJson = (JSONArray) modulesJson.get("steps");
            parseSteps(stepsJson);
        } catch (IOException e) {
            //problems with loading file
            e.printStackTrace();
        } catch (ParseException e) {
            //problems with parsing file
            e.printStackTrace();
        }
    }

    public static void refresh() {

    }

    private static void parseSteps(JSONArray stepsJson) {
        Stream<StepConfig> s = stepsJson.stream().map(transformStepJson);
        steps = s.collect(Collectors.toList());
        System.out.println("Parsed steps:" + steps);
    }

    public static ModuleConfig step(String stepKey) {
        return steps.stream().filter(s -> s.getString(StepConfig.KEY).equals(stepKey)).findFirst().get();
    }
}
