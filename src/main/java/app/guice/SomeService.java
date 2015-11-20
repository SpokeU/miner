package app.guice;

import javax.inject.Singleton;

@Singleton
public class SomeService {
    public void doStuff() {
        System.out.println("doing important stuff...");
    }
}
