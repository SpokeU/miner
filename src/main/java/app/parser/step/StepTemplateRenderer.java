package app.parser.step;

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
import app.parser.Modules;
import app.parser.Modules.StepConfig;
import app.parser.step.configurators.GetPageConfigurator;

//Module tempalte renderer
public class StepTemplateRenderer {

	TemplateManager templateManager = Configuration.getTemplateManager();

	public String renderTempalte(String actionName, String stepKey) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
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

	// TODO implement
	private String getTemplateName(String actionName, String stepKey) {
		StepConfig stepConfig = Modules.steps.stream().filter(s -> s.getKey().equals(stepKey)).findFirst().get();
		return "/steps/getPage/view";
	}

	// TODO implement
	private StepConfigurator getConfigurator(String actionName, String stepKey) {
		// find configurator className Inflector.camelize(stepKey, true) + "Configurator";
		// Guice.createInjector(new
		// AppInjector()).getInstance(foundConfiguratorClass.class);
		return Guice.createInjector(new AppInjector()).getInstance(GetPageConfigurator.class);
	}
}
