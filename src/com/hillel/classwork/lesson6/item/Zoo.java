package com.hillel.classwork.lesson6.item;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    public static void main(String[] args) {
        Duck duck = new Duck("krya");
        Swimmable duck2 = new Duck("krya2");
        Swimmable ship = new Ship();

        List<Swimmable> swimmables = new ArrayList<>();
        swimmables.add(duck);
        swimmables.add(duck2);
        swimmables.add(ship);

        for (Swimmable swimmable : swimmables) {
            swimmable.swim();
        }
    }
}
