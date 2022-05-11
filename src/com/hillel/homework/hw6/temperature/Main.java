package com.hillel.homework.hw6.temperature;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {

        List<Converter> converters = new ArrayList<>();

        String actionMessage = "Choose action: 1.convert temperature. 2. press any key to exit";
        System.out.println(actionMessage);
        while (SCANNER.nextLine().toLowerCase(Locale.ROOT).replaceAll(" ", "").equals("convert")) {
            Converter converter = create();
            if (converter != null) converters.add(converter);
            System.out.println(actionMessage);
        }


        if (converters.size() != 0) {
            System.out.println("\tConverting history:");
            for (Converter converter : converters) {
                System.out.println("--------------------------------");
                if (converter instanceof Celsius)
                    System.out.println("Celsius temperature = " + ((Celsius) converter).getStart() + "C");
                if (converter instanceof Kelvin)
                    System.out.println("Kelvin temperature = " + ((Kelvin) converter).getStart() + "K");
                if (converter instanceof Fahrenheit)
                    System.out.println("Fahrenheit temperature = " + ((Fahrenheit) converter).getStart() + "F");
                System.out.printf("Converted temperature to %s = %.2f \n", ((Temperature) converter).getToType(), converter.convert());
            }


            System.out.println("\n\tBonus");
            for (Converter converter : converters) {
                System.out.println(converter);
                System.out.println("--------------------------------");
            }
        } else System.out.println("There were no converting");
    }

    public static Converter create() {
        System.out.println("Input first degree type: celsius, fahrenheit, kelvin");
        String fromType = SCANNER.nextLine().toLowerCase(Locale.ROOT).replaceAll(" ", "");
        if (!fromType.equals("celsius") && !fromType.equals("fahrenheit") && !fromType.equals("kelvin")) {
            System.out.println("Incorrect degree type " + fromType + ". Try again");
            return null;
        }
        System.out.println("Input first degree amount");
        String number = SCANNER.nextLine();
        if (isFloat(number)) {
            float start = Float.parseFloat(number);
            System.out.println("Input second degree type: celsius, fahrenheit, kelvin");
            String toType = SCANNER.nextLine().toLowerCase(Locale.ROOT).replaceAll(" ", "");
            if (!toType.equals("celsius") && !toType.equals("fahrenheit") && !toType.equals("kelvin")) {
                System.out.println("Incorrect degree type " + toType + ". Try again");
                return null;
            }
            if (fromType.equals(toType)) {
                System.out.println("Types are same. Try again");
                return null;
            }
            switch (fromType) {
                case "celsius":
                    return new Celsius(start, toType);
                case "fahrenheit":
                    return new Fahrenheit(start, toType);
                case "kelvin":
                    return new Kelvin(start, toType);
                default:
                    System.out.println("Incorrect degree type " + toType + ". Try again");
                    return null;
            }
        }
        System.out.println("Incorrect number, try again.");
        return null;
    }

    public static boolean isFloat(String start) {
        if (start == null) return false;
        try {
            Float.parseFloat(start);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}

