package app.guice;

import javax.inject.Singleton;

@Singleton
public class EmailService implements MessageService {

    @Override
    public void sendMessage(String msg, String receipient) {
        System.out.println("Email sent to " + receipient + " .message:" + msg);
    }
}
