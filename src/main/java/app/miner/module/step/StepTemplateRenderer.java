package app.miner.module.step;

import app.miner.api.StepConfigurator;
import app.miner.module.Modules;
import org.javalite.activeweb.Configuration;
import org.javalite.activeweb.TemplateManager;
import org.javalite.common.Inflector;

import javax.inject.Singleton;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


//Module tempalte renderer
@Singleton
public class StepTemplateRenderer {

    TemplateManager templateManager = Configuration.getTemplateManager();

    public String renderTemplate(String viewType, String stepKey) throws Exception {
        StepConfigurator configurator = StepConfiguratorFactory.forKey(stepKey);
        String template = getTemplateName(viewType, stepKey);
        Map<String, Object> templateData = getDataForTemplate(configurator, viewType);

        StringWriter writer = new StringWriter();
        templateManager.merge(templateData, template, writer);

        return writer.toString();
    }

    private Map<String, Object> getDataForTemplate(StepConfigurator configurator, String viewType) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        Map<String, Object> params = new HashMap<>();
        String populateMethodName = "populate" + Inflector.capitalize(viewType) + "Parameters";
        Method populateMethod = configurator.getClass().getDeclaredMethod(populateMethodName, Map.class);
        populateMethod.invoke(configurator, params);
        return params;
    }

    // TODO implement from config
    private String getTemplateName(String viewType, String stepKey) {
        String templatePath = Modules.forKey(stepKey).getProperty(viewType + "_template");
        return templatePath;
    }

}
