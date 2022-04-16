package com.hillel.classwork.lesson6.greeting;

import com.hillel.classwork.lesson6.item.*;
import com.hillel.classwork.lesson6.item.Runnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class SauHi {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {

        List<Greeting> greetings = new ArrayList<>();

        String actionMessage = "Choose action: 1.create object. 2. press any key to exit";
        System.out.println(actionMessage);
        while (SCANNER.nextLine().toLowerCase(Locale.ROOT).replaceAll(" ", "").equals("create")) {
            Greeting item = create();
            if (item != null) greetings.add(item);
            System.out.println(actionMessage);
        }

        for (Greeting item : greetings) {
            item.hi();
        }
    }

    public static Greeting create() {
        System.out.println("Input greeting type: kind, angry");
        String objectType = SCANNER.nextLine();
        switch (objectType.toLowerCase(Locale.ROOT).replaceAll(" ", "")) {
            case "kind":
                return new KindGreeting();
            case "angry":
                return new AngryGreeting();
            default:
                System.out.println("Incorrect greeting type " + objectType + ". Try again");
                return null;
        }
    }
}
