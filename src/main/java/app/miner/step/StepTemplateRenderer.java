package app.miner.step;

import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.javalite.activeweb.Configuration;
import org.javalite.activeweb.TemplateManager;
import org.javalite.common.Inflector;

import com.google.inject.Guice;

import app.guice.AppInjector;
import app.miner.api.StepConfigurator;
import app.miner.module.ModuleType;


//Module tempalte renderer
public class StepTemplateRenderer {

    TemplateManager templateManager = Configuration.getTemplateManager();

    public String renderTemplate(String actionName, String stepKey) throws Exception {
        StepConfigurator configurator = getConfigurator(stepKey);
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
        String templatePath = "/steps/" + Inflector.camelize(stepKey, false) + "/" + actionName;
        return templatePath;
    }

    public StepConfigurator getConfigurator(String stepKey) throws ClassNotFoundException {
        Class<StepConfigurator> stepConfiguratorClass = getConfiguratorClass(stepKey);
        return Guice.createInjector(new AppInjector()).getInstance(stepConfiguratorClass);
    }
    
    private Class<StepConfigurator> getConfiguratorClass(String stepKey) throws ClassNotFoundException{
    	String configuratorClass = null;ModuleType.STEP.get(stepKey);
        if(configuratorClass == null){
        	String basePackage = "app.miner";
            String stepsConfiguratorPackage = basePackage + ".step.configurators";
            configuratorClass = stepsConfiguratorPackage + "." + Inflector.camelize(stepKey, true) + "Configurator";
        }
		return (Class<StepConfigurator>) Class.forName(configuratorClass).asSubclass(StepConfigurator.class);
    }
}
