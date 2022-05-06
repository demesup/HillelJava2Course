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
                return 0;
        }
    }

    @Override
    public String toString() {
        if (toType.equals("kelvin")) return " Fahrenheit temperature = " + start +
                "\n Kelvin temperature = " + convert();
        if (toType.equals("celsius")) return " Fahrenheit temperature = " + start +
                "\n Celsius temperature = " + convert();
        return "Error...";
    }
}
