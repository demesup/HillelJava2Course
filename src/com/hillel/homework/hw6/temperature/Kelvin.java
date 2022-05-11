package com.hillel.homework.hw6.temperature;

public class Kelvin extends Temperature implements ToFahrenheit, ToCelsius {

    public Kelvin(float start, String toType) {
        super(start, toType);
    }

    @Override
    public float toCelsius() {
        return start - 273.15f;
    }

    @Override
    public float toFahrenheit() {
        return (start - 273.15f) * 9 / 5 + 32;
    }

    @Override
    public float convert() {
        switch (toType) {
            case "fahrenheit":
                return toFahrenheit();
            case "celsius":
                return toCelsius();
            default:
                System.out.println("Error...");
                return 0;
        }
    }

    @Override
    public String toString() {
        return "Kelvin temperature is " + start + "K\n" +
                "Celsius temperature = " + DECIMAL_FORMAT.format(toCelsius()) + "C\n" +
                "Fahrenheit temperature = " + DECIMAL_FORMAT.format(toFahrenheit()) + "F";
    }
}
