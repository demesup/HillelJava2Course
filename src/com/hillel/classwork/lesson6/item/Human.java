package com.hillel.classwork.lesson6.item;

import com.hillel.Item;

public class Human extends Item implements Swimmable,Runnable, Flyable,Eatable{

    @Override
    public void swim() {
        System.out.println("Human is swimming...");
    }

    @Override
    public void run() {
        System.out.println("Human is running...");
    }

    @Override
    public void fly() {
        System.out.println("Human is flying...");
    }

    @Override
    public void eat() {
        System.out.println("Human is eating...");
    }

    @Override
    public String toString() {
        return "Human{}";
    }
}
