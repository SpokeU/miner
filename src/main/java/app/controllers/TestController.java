package app.controllers;

import app.guice.AppInjector;
import app.guice.MessageService;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.javalite.activeweb.AppController;
import org.javalite.activeweb.annotations.GET;

import javax.inject.Inject;


/**
 * Created by Issen on 19.11.2015.
 */
public class TestController extends AppController {

    @Inject
    private MessageService emailService;

    @GET
    public void guiceTest() {
        Injector injector = Guice.createInjector(new AppInjector());

        MessageService app = injector.getInstance(MessageService.class);

        app.sendMessage("Hi Pankaj", "pankaj@abc.com");
        emailService.sendMessage("Gogogo", "omy@gmail.com");
    }

}
