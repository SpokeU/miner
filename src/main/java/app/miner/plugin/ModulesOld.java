package app.miner.plugin;

import com.google.common.collect.Sets;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ModulesOld {

    private static JSONParser parser = new JSONParser();

    public static Set<ModuleConfig> steps = Sets.newConcurrentHashSet();

    public static Function<JSONObject, StepConfig> transformStepJson = stepJson -> {
        return new StepConfig(stepJson);
    };

    public static void init() {
        File modulesFile = new File(ModulesOld.class.getClassLoader().getResource("modules.json").getFile());
        try {
            JSONObject modulesJson = (JSONObject) parser.parse(new FileReader(modulesFile));
            JSONArray stepsJson = (JSONArray) modulesJson.get("steps");
            addSteps(stepsJson);
        } catch (IOException e) {
            //problems with loading file
            e.printStackTrace();
        } catch (ParseException e) {
            //problems with parsing file
            e.printStackTrace();
        }
    }

    private static void addSteps(JSONArray stepsJson) {
        Stream<StepConfig> s = stepsJson.stream().map(transformStepJson);
        steps.addAll(s.collect(Collectors.toSet()));
        System.out.println("Added steps:" + steps);
    }

    /*public static void addModules(JSONObject pluginJson){
        addSteps((JSONArray) pluginJson.get("steps"));
    }

    public static void addPlugin(String pluginDescriptorFile) throws ParseException {
        addModules((JSONObject) parser.parse(pluginDescriptorFile));
    }*/

    public static ModuleConfig step(String stepKey) {
        return steps.stream().filter(s -> s.getString(StepConfig.KEY).equals(stepKey)).findFirst().get();
    }
}
