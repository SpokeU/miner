package app.parser.step.configurators;

import java.util.Map;

import javax.inject.Inject;

import app.guice.MessageService;
import app.parser.step.StepConfigurator;

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

    }

    @Override
    public void populateCreateParameters(Map<String, String> createParams) {

    }
}
