package com.hillel.classwork.lesson6.item;


import com.hillel.Item;

import java.util.*;

public class Main {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {

        List<Item> items = new ArrayList<>();

        String actionMessage = "Choose action: 1.create object. 2. press any key to exit";
        System.out.println(actionMessage);
        while (SCANNER.nextLine().toLowerCase(Locale.ROOT).replaceAll(" ", "").equals("create")) {
            Item item = create();
            if (item != null) items.add(item);
            System.out.println(actionMessage);
        }

        for (Item propertyTax : items) {
            System.out.println(propertyTax);
            if (propertyTax instanceof Flyable) ((Flyable) propertyTax).fly();
            if (propertyTax instanceof Runnable) ((Runnable) propertyTax).run();
            if (propertyTax instanceof Swimmable) ((Swimmable) propertyTax).swim();
            if (propertyTax instanceof Eatable) ((Eatable) propertyTax).eat();
            System.out.println();
        }
    }

    public static Item create() {
        System.out.println("Input object type: duck, human, ship, sheep");
        String objectType = SCANNER.nextLine();
        switch (objectType.toLowerCase(Locale.ROOT).replaceAll(" ", "")) {
            case "duck":
                System.out.println("Input name: ");
                String name = SCANNER.nextLine();
                return new Duck(name);
            case "human":
                return new Human();
            case "ship":
                return new Ship();
            case "sheep":
                return new Sheep();
            default:
                System.out.println("Incorrect object type " + objectType + ". Try again");
                return null;
        }
    }
}