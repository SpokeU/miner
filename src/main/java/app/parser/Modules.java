package app.parser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Modules {

    private static JSONParser parser = new JSONParser();

    public static List<StepConfig> steps = new ArrayList<StepConfig>();

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
    
    private static void parseSteps(JSONArray stepsJson){
    	Stream<StepConfig> s = stepsJson.stream().map(transformStepJson);
    	steps = s.collect(Collectors.toList());
    	System.out.println("Parsed steps:" + steps);
    }
    
	public static StepConfig step(String stepKey){
    	return steps.stream().filter(s -> s.getKey().equals(stepKey)).findFirst().get();
    }


    public static class StepConfig {
        private JSONObject stepConfigJson;

        public StepConfig(JSONObject config) {
            stepConfigJson = config;
        }

        public String getKey() {
            return (String) stepConfigJson.get("key");
        }

        public String getName() {
            return (String) stepConfigJson.get("name");
        }

        public String getProcessorClass() {
            return null;
        }

        public String getConfiguratorClass() {
            return null;
        }

        public String getViewTemplate() {
            return null;
        }

        public String getEditTemplate() {
            return null;
        }

        public String getCreateTemplate() {
            return null;
        }
    }
}
