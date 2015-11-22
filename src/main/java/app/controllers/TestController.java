package app.controllers;

import app.guice.AppInjector;
import app.guice.MessageService;
import app.guice.SomeService;
import app.parser.ParserManager;
import app.parser.models.Step;
import app.parser.models.StepConfiguration;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.javalite.activeweb.AppController;
import org.javalite.activeweb.annotations.GET;

import javax.inject.Inject;
import java.util.List;


/**
 * Created by Issen on 19.11.2015.
 */
public class TestController extends AppController {

    @Inject
    private MessageService emailService;

    @Inject
    private SomeService someService;

    @Inject
    private ParserManager parseManager;

    @GET
    public void guiceTest() {
        Injector injector = Guice.createInjector(new AppInjector());

        MessageService app = injector.getInstance(MessageService.class);

        app.sendMessage("Hi Pankaj", "pankaj@abc.com");
        emailService.sendMessage("Gogogo", "omy@gmail.com");

        someService.doStuff();
    }

    @GET
    public void parseTest(){
        parseManager.executeJob(1L);
    }

    @GET
    public void testQuery(){
        List<Step> steps = Step.where(Step.parse_job_id + " = ? order by step_order", 1L).include(StepConfiguration.class);
        System.out.println(steps);
        System.out.println(steps.get(1).getAll(StepConfiguration.class));
        List<StepConfiguration> conf = StepConfiguration.findAll();
        System.out.println(conf);
    }

}
