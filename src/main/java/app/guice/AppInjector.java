package app.guice;

import com.google.inject.AbstractModule;

/**
 * Created by Issen on 19.11.2015.
 */
public class AppInjector extends AbstractModule {

    @Override
    protected void configure() {
        //bind the service to implementation class
        //bind(MessageService.class).to(EmailService.class);

        //bind MessageService to Facebook Message implementation
        bind(MessageService.class).to(EmailService.class);

    }

}
