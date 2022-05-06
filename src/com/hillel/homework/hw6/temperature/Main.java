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
                System.out.println(converter);
            }
        } else System.out.println("There were no converting");

        if (converters.size() != 0) {
            System.out.println("\n\tConverting history 2");
            for (Converter converter : converters) {
                System.out.println("--------------------------------");
                if (converter instanceof ToCelsius) ((ToCelsius) converter).toCelsius();
                if (converter instanceof ToKelvin) ((ToKelvin) converter).toKelvin();
                if (converter instanceof ToFahrenheit) ((ToFahrenheit) converter).toFahrenheit();
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
        float start = Float.parseFloat(SCANNER.nextLine());
        System.out.println("Input second degree type: celsius, fahrenheit, kelvin");
        String toType = SCANNER.nextLine().toLowerCase(Locale.ROOT).replaceAll(" ", "");
        if (!toType.equals("celsius") && !toType.equals("fahrenheit") && !toType.equals("kelvin")) {
            System.out.println("Incorrect degree type " + toType + ". Try again");
            return null;
        }
        if (fromType.equals(toType)) {
            System.out.println("Types are same");
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
}

