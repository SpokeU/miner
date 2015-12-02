package app.parser.step;

import app.guice.AppInjector;
import app.parser.Modules;
import app.parser.Modules.StepConfig;
import com.google.inject.Guice;
import org.javalite.activeweb.Configuration;
import org.javalite.activeweb.TemplateManager;
import org.javalite.common.Inflector;

import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

//Module tempalte renderer
public class StepTemplateRenderer {

    TemplateManager templateManager = Configuration.getTemplateManager();

    public String renderTemplate(String actionName, String stepKey) throws Exception {
        StepConfigurator configurator = getConfigurator(actionName, stepKey);
        String template = getTemplateName(actionName, stepKey);
        Map<String, Object> templateData = getDataForTemplate(configurator, actionName);

        StringWriter writer = new StringWriter();
        templateManager.merge(templateData, template, writer);

        return writer.toString();
    }

    private Map<String, Object> getDataForTemplate(StepConfigurator configurator, String actionName) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        Map<String, Object> params = new HashMap<>();
        String populateMethodName = "populate" + Inflector.capitalize(actionName) + "Parameters";
        Method populateMethod = configurator.getClass().getDeclaredMethod(populateMethodName, Map.class);
        populateMethod.invoke(configurator, params);
        return params;
    }

    // TODO implement from config
    private String getTemplateName(String actionName, String stepKey) {
        StepConfig stepConfig = Modules.steps.stream().filter(s -> s.getKey().equals(stepKey)).findFirst().get();
        String templatePath = "/steps/" + Inflector.camelize(stepKey, false) + "/" + actionName;
        return templatePath;
    }

    //TODO implement get from StepConfig
    private StepConfigurator getConfigurator(String actionName, String stepKey) throws ClassNotFoundException {
        String basePackage = "app.parser";
        String stepsConfiguratorPackage = basePackage + ".step.configurators";
        String configuratorClassName = stepsConfiguratorPackage + "." + Inflector.camelize(stepKey, true) + "Configurator";
        Class<StepConfigurator> stepConfiguratorClass = (Class<StepConfigurator>) Class.forName(configuratorClassName).asSubclass(StepConfigurator.class);
        return Guice.createInjector(new AppInjector()).getInstance(stepConfiguratorClass);
    }
}
