package app.miner.module.step.configurators;

import app.guice.MessageService;
import app.miner.api.StepConfigurator;
import com.google.common.collect.Maps;

import javax.inject.Inject;
import java.util.Map;

public class GetPageConfigurator implements StepConfigurator{
	
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
		return Maps.newHashMap();
	}
}
