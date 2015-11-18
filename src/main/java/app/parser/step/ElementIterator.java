package app.parser.step;

import app.parser.BaseStep;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Created by Issen on 15.11.2015.
 */
public class ElementIterator extends BaseStep {

    public static class ConfigurationParameters {
        public static String SELECTOR = "SELECTOR";
        public static String ITERATOR_ACTION = "ITERATOR_ACTION";
    }

    @Override
    public Map<String, Object> processStep(Map<String, Object> data) {
        Document doc = (Document) data.get(GetPage.DataParameters.PAGE_CONTENT);
        try {
            Files.write(Paths.get("C:\\index.html"), doc.html().getBytes("utf-8"));
        }   catch (IOException e) {
            e.printStackTrace();
        }
        String selector = (java.lang.String) config().get(ConfigurationParameters.SELECTOR);
        Consumer<Element> action = (Consumer<Element>) config().get(ConfigurationParameters.ITERATOR_ACTION);

        doc.select(selector).forEach(action);
        return data;
    }

    @Override
    public Map<String, Object> preProcess(Map<String, Object> data) {
        Map<String, Object> config= new HashMap<>();
        Consumer<Element> action = element -> {
            java.lang.String value = element.text();
            System.out.println(value);
        };
        config.put(ConfigurationParameters.ITERATOR_ACTION, action);
        config.put(ConfigurationParameters.SELECTOR, "li[name=m-main-i]");
        setConfig(config);
        return data;
    }

    @Override
    public Map<String, Object> postProcess(Map<String, Object> data) {
        return data;
    }
}
