package com.hillel.homework.hw6.temperature;

public class Celsius extends Temperature implements ToKelvin, ToFahrenheit {

    public Celsius(float start, String toType) {
        super(start, toType);
    }

    @Override
    public float convert() {
        switch (toType) {
            case "fahrenheit":
                return toFahrenheit();
            case "kelvin":
                return toKelvin();
            default:
                return 0;
        }
    }

    @Override
    public float toFahrenheit() {
        return start * 9 / 5 + 32;
    }

    @Override
    public float toKelvin() {
        return (start + 273.15f);
    }

    @Override
    public String toString() {
        if (toType.equals("kelvin")) return " Celsius temperature = " + start +
                "\nKelvin temperature = " + convert();
        if (toType.equals("fahrenheit")) return " Celsius temperature = " + start +
                "\nFahrenheit temperature = " + convert();
        return "Error...";
    }
}
