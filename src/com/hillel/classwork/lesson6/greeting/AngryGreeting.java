package com.hillel.classwork.lesson6.greeting;

public class AngryGreeting implements Greeting {
    @Override
    public void hi() {
        System.out.println("Go away!");
    }
}
