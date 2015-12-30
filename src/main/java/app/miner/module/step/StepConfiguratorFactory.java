package app.miner.module.step;

import app.guice.AppInjector;
import app.miner.api.StepConfigurator;
import app.miner.module.Modules;
import app.miner.module.Properties;
import com.google.inject.Guice;
import org.javalite.common.Inflector;

/**
 * TODO think about moving it into StepConfigurator
 */
public class StepConfiguratorFactory {

    private StepConfiguratorFactory() {
    }

    public static StepConfigurator forKey(String stepKey) {
        Class<StepConfigurator> stepConfiguratorClass = getConfiguratorClass(stepKey);
        return Guice.createInjector(new AppInjector()).getInstance(stepConfiguratorClass);
    }

    private static Class<StepConfigurator> getConfiguratorClass(String stepKey) {
        Class<StepConfigurator> configuratorClass = null;
        String configuratorClassName = Modules.forKey(stepKey).getProperty(Properties.StepProperties.CONFIGURATOR_CLASS);
        if (configuratorClassName == null) {
            configuratorClassName = generateConfiguratorClassName(stepKey);
        }
        try {
            configuratorClass = (Class<StepConfigurator>) Class.forName(configuratorClassName).asSubclass(StepConfigurator.class);
        } catch (ClassNotFoundException e) {
            //TODO handle exception
            e.printStackTrace();
        }
        return configuratorClass;
    }

    private static String generateConfiguratorClassName(String stepKey) {
        String stepsConfiguratorPackage = Properties.BASE_PACKAGE + ".module.step.configurators";
        return stepsConfiguratorPackage + "." + Inflector.camelize(stepKey, true) + "Configurator";
    }

}
