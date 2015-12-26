package app.miner.module.step;

import app.guice.AppInjector;
import app.miner.api.StepConfigurator;
import app.miner.module.Modules;
import app.miner.module.Properties;
import com.google.inject.Guice;
import org.javalite.activeweb.Configuration;
import org.javalite.activeweb.TemplateManager;
import org.javalite.common.Inflector;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


//Module tempalte renderer
@Singleton
public class StepTemplateRenderer {
	
	@Inject Modules modules;

    TemplateManager templateManager = Configuration.getTemplateManager();

    public String renderTemplate(String viewType, String stepKey) throws Exception {
        StepConfigurator configurator = getConfigurator(stepKey);
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
        String templatePath = "/steps/" + Inflector.camelize(stepKey, false) + "/" + viewType;
        return templatePath;
    }

    public StepConfigurator getConfigurator(String stepKey) throws ClassNotFoundException {
        Class<StepConfigurator> stepConfiguratorClass = getConfiguratorClass(stepKey);
        return Guice.createInjector(new AppInjector()).getInstance(stepConfiguratorClass);
    }
    
    private Class<StepConfigurator> getConfiguratorClass(String stepKey) throws ClassNotFoundException{
    	String configuratorClass = modules.forKey(stepKey).getProperty(Properties.StepProperties.CONFIGURATOR_CLASS);
        if(configuratorClass == null){
            configuratorClass = generateConfiguratorClassName(stepKey);
        }
        System.out.println(configuratorClass);
        return (Class<StepConfigurator>) Class.forName(configuratorClass).asSubclass(StepConfigurator.class);
    }

    private String generateConfiguratorClassName(String stepKey){
        String stepsConfiguratorPackage = Properties.BASE_PACKAGE + ".module.step.configurators";
        return stepsConfiguratorPackage + "." + Inflector.camelize(stepKey, true) + "Configurator";
    }
}
