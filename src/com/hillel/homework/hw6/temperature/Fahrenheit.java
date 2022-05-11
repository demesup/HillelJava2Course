package com.hillel.homework.hw6.temperature;

public class Fahrenheit extends Temperature implements ToCelsius, ToKelvin {

    public Fahrenheit(float start, String toType) {
        super(start, toType);
    }

    @Override
    public float toCelsius() {
        return (start - 32) * 5 / 9;
    }

    @Override
    public float toKelvin() {
        return (start - 32) * 5 / 9 + 273.15f;
    }

    @Override
    public float convert() {
        switch (toType) {
            case "celsius":
                return toCelsius();
            case "kelvin":
                return toKelvin();
            default:
                System.out.println("Error...");
                return 0;
        }
    }

    @Override
    public String toString() {
        return "Fahrenheit temperature is " + start + "F\n" +
                "Kelvin temperature = " + DECIMAL_FORMAT.format(toKelvin()) + "K\n" +
                "Celsius temperature = " + DECIMAL_FORMAT.format(toCelsius()) + "C";
    }
}
