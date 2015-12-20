package app.guice;

import javax.inject.Singleton;

@Singleton
public class SomeService {
    public void doStuff() {
        System.out.println("doing important stuff...");
    }

    public static void main(String []args){
        String b = "aaaaa";
        String a = new String("aaaaa");
        String b11 = a.intern();


        String a1 = "a";
        String b1 = "a";
        System.out.print(b == b11);
    }

    public static class Person{
        private String name;
        private Integer age;

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
    }

}
