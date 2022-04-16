package com.hillel.classwork.lesson6.item;

public class Ship extends Item implements Swimmable{

    @Override
    public void swim() {
        System.out.println("Ship is swimming...");
    }

    @Override
    public String toString() {
        return "Ship{}";
    }
}
