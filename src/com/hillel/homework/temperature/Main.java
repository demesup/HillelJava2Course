package com.hillel.homework.temperature;

import com.hillel.Item;
import com.hillel.classwork.lesson6.item.*;
import com.hillel.classwork.lesson6.item.Runnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {

        List<Converter> converters = new ArrayList<>();

        String actionMessage = "Choose action: 1.create object. 2. press any key to exit";
        System.out.println(actionMessage);
        while (SCANNER.nextLine().toLowerCase(Locale.ROOT).replaceAll(" ", "").equals("create")) {
            Converter converter = create();
            if (converter != null) converters.add(converter);
            System.out.println(actionMessage);
        }

        for (Converter converter : converters) {
            System.out.println(converter);
            if (converter instanceof Flyable) ((Flyable) converter).fly();
            if (converter instanceof Runnable) ((Runnable) converter).run();
            if (converter instanceof Swimmable) ((Swimmable) converter).swim();
            if (converter instanceof Eatable) ((Eatable) converter).eat();
            System.out.println();
        }
    }

    public static Converter create() {
        System.out.println("Input degree type: celsius, fahrenheit, kelvin");
        String objectType = SCANNER.nextLine();
        switch (objectType.toLowerCase(Locale.ROOT).replaceAll(" ", "")) {
            case "celsius":
                return new Celsius();
            case "fahrenheit":
                return new Fahrenheit();
            case "kelvin":
                return new Kelvin();
            default:
                System.out.println("Incorrect degree type " + objectType + ". Try again");
                return null;
        }
    }
}
