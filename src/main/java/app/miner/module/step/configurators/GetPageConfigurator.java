package app.miner.module.step.configurators;

import app.guice.MessageService;
import app.miner.module.step.AbstractStepConfigurator;

import javax.inject.Inject;
import java.util.Map;
import java.util.stream.Collectors;

public class GetPageConfigurator extends AbstractStepConfigurator {

    @Inject
    private MessageService messageService;

    @Override
    public void populateViewParameters(Map<String, String> viewParams) {
        viewParams.put("mymessage", "Hello message from super service");
        messageService.sendMessage("Injection working", "System");
    }

    @Override
    public void populateEditParameters(Map<String, String> editParams) {
        editParams.put("mymessage", "Hello message from super service");
        messageService.sendMessage("Injection working", "System");
    }

    @Override
    public void populateCreateParameters(Map<String, String> createParams) {
        createParams.put("mymessage", "Hello message from super service");
        messageService.sendMessage("Injection working", "System");
    }

    @Override
    public Map<String, String> onSave(Map<String, String[]> params) {
        Map<String, String> paramsToSave = params.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue()[0]));
        return paramsToSave;
    }
}
