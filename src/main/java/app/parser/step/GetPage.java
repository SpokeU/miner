package app.parser.step;

import app.parser.BaseStep;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Issen on 15.11.2015.
 */
public class GetPage extends BaseStep {

    public static class DataParameters {
        public static String URL = "URL";
        public static String PAGE_CONTENT = "PAGE_CONTENT";
    }

    @Override
    public Map<String, Object> processStep(Map<String, Object> data) {
        String url = (java.lang.String) data.get(DataParameters.URL);

        try {
            Document doc = Jsoup.connect(url).get();
            data.put(DataParameters.PAGE_CONTENT, doc);
        } catch (IOException e) {
            System.out.println("Something went wrong while downloading page " + url);
            e.printStackTrace();
        }

        return data;
    }

    @Override
    public Map<String, Object> preProcess(Map<String, Object> data) {
        return data;
    }

    @Override
    public Map<String, Object> postProcess(Map<String, Object> data) {
        return data;
    }

    private void extractParameters(Map<String, Object> data){

    }
}
