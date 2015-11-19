package app.controllers;

import app.guice.MessageService;
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
        emailService.sendMessage("Gogogo", "omy@gmail.com");
    }

}
