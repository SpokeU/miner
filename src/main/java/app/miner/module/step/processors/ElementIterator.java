package app.miner.module.step.processors;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import app.miner.module.step.AbstractStepProcessor;

import java.util.Map;
import java.util.function.Consumer;

/**
 * Created by Issen on 15.11.2015.
 */
public class ElementIterator extends AbstractStepProcessor {

    public static class ConfigurationParameters {
        public static String SELECTOR = "SELECTOR";
        public static String ACTION = "ITERATOR_ACTION";
    }

    public static class Actions {
        public static final Consumer<Element> ECHO_ACTION = element -> {
            java.lang.String value = element.text();
            System.out.println(value);
        };
    }

    private String selector;
    private Consumer<Element> action;


    @Override
    public void initialize(Map<String, Object> config) {
        selector = (String) config.get(ConfigurationParameters.SELECTOR);
        action = Actions.ECHO_ACTION; // TODO HARDCODE!
        //String acitonName = (String) config.get(ConfigurationParameters.ACTION);
    }

    @Override
    public Map<String, Object> processStep(Map<String, Object> data) {
        Document doc = (Document) data.get(GetPage.DataParameters.PAGE_CONTENT);
        doc.select(selector).forEach(action);
        return data;
    }

}
