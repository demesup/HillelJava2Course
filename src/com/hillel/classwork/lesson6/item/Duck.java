package com.hillel.classwork.lesson6.item;

import com.hillel.Item;

public class Duck extends Item implements Swimmable,Flyable,Runnable,Eatable  {

    private final String name;

    public Duck(String name) {
        this.name = name;
    }

    @Override
    public void swim() {
        System.out.println("Duck is swimming...");
    }

    @Override
    public void fly() {
        System.out.println("Duck is flying...");
    }

    @Override
    public void run() {
        System.out.println("Duck is running...");
    }

    @Override
    public void eat() {
        System.out.println("Duck is eating...");
    }

    @Override
    public String toString() {
        return "Duck{" +
                "name='" + name + '\'' +
                '}';
    }

}
