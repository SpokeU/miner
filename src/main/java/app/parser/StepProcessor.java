package app.parser;

import app.parser.step.GetPage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StepProcessor {

    public static void processSteps(List<? extends BaseStep> steps){
        Map initialData = new HashMap<>();
        initialData.put(GetPage.DataParameters.URL, "http://rozetka.com.ua/");
        for (BaseStep step : steps) {
            Map data = step.preProcess(initialData);
            data = step.processStep(data);
            step.postProcess(data);
        }

    }
}
