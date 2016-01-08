package app.miner.module;

import com.google.common.collect.Lists;
import org.apache.commons.io.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class ConfigParser {

    private static JSONParser parser = new JSONParser();

    public static List<Module> getModules(URL filePath) {
        return getModules(parseConfigFile(filePath));
    }

    @SuppressWarnings("unchecked")
    //TODO handle exceptions when config file is wrong
    public static List<Module> getModules(JSONObject jsonConfig) {

        List<Module> result = Lists.newArrayList();
        JSONArray modules = (JSONArray) jsonConfig.get("modules");
        if (modules != null) {
            modules.forEach(module -> result.add(new Module((JSONObject) module)));
        }
        return result;
    }

    private static JSONObject parseConfigFile(URL filePath) {
        JSONObject jsonConfig = null;
        try (InputStream configFileStream = filePath.openStream()) {
            String configFile = IOUtils.toString(filePath.openStream());
            jsonConfig = (JSONObject) parser.parse(configFile);

        } catch (IOException e) {
            e.printStackTrace();
            // cant find resource
        } catch (ParseException pe) {
            // invalid config file
        }
        return jsonConfig;
    }

}
