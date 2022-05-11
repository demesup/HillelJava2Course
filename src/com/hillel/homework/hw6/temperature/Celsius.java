package com.hillel.homework.hw6.temperature;

public class Celsius extends Temperature implements ToKelvin, ToFahrenheit {

    public Celsius(float start, String toType) {
        super(start, toType);
    }

    @Override
    public float toFahrenheit() {
        return start * 9 / 5 + 32;
    }

    @Override
    public float toKelvin() {
        return start + 273.15f;
    }


    @Override
    public float convert() {
        switch (toType) {
            case "fahrenheit":
                return toFahrenheit();
            case "kelvin":
                return toKelvin();
            default:
                System.out.println("Error...");
                return 0;
        }
    }

    @Override
    public String toString() {
        return "Celsius temperature is " + start + "C\n" +
                "Fahrenheit temperature = " + DECIMAL_FORMAT.format(toFahrenheit()) + "F\n" +
                "Kelvin temperature = " + DECIMAL_FORMAT.format(toKelvin()) + "K\n";

    }
}
