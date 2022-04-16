package com.hillel.classwork.lesson6.item;

import com.hillel.Item;

public class Sheep extends Item implements Runnable,Eatable{
    @Override
    public void run() {
        System.out.println("Sheep is running...");
    }

    @Override
    public void eat() {
        System.out.println("Sheep is eating...");
    }

    @Override
    public String toString() {
        return "Sheep{}";
    }
}
