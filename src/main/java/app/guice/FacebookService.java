package app.guice;


import javax.inject.Singleton;

@Singleton
public class FacebookService implements MessageService{
    @Override
    public void sendMessage(String msg, String receipient) {
        System.out.println("Facebook sent to " + receipient + " .message:" + msg);
    }
}
