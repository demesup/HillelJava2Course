package com.hillel.classwork.lesson6.item;


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

        for (Item item:items ) {
            System.out.println(item);
            if (item instanceof Flyable) ((Flyable) item).fly();
            if (item instanceof Runnable) ((Runnable) item).run();
            if (item instanceof Swimmable) ((Swimmable) item).swim();
            if (item instanceof Eatable) ((Eatable) item).eat();
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
