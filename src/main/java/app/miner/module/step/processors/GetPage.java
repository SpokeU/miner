package app.miner.module.step.processors;

import app.guice.MessageService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import app.miner.module.step.AbstractStepProcessor;

import javax.inject.Inject;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Issen on 15.11.2015.
 */
public class GetPage extends AbstractStepProcessor {

    @Inject
    private MessageService messageService;
	
	private String url;

    public static class DataParameters {
        public static String URL = "url";
        public static String PAGE_CONTENT = "PAGE_CONTENT";
    }

    @Override
    public void initialize(Map<String, Object> config) {
    	url = (String) config.get(DataParameters.URL);
    }

    @Override
    public Map<String, Object> processStep(Map<String, Object> data) {
        messageService.sendMessage("Step processor injector is working", this.getClass().getName());
        try {
            Document doc = Jsoup.connect(url).get();
            data.put(DataParameters.PAGE_CONTENT, doc);
            System.out.println(doc.getElementById("header_home"));
        } catch (IOException e) {
            System.out.println("Something went wrong while downloading page " + url);
            e.printStackTrace();
        }

        return data;
    }

}
