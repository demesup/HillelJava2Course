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
                return 0;
        }
    }

    @Override
    public String toString() {
        if (toType.equals("fahrenheit")) return " Kelvin temperature = " + start +
                "\n Fahrenheit temperature = " + convert();
        if (toType.equals("celsius")) return " Kelvin temperature = " + start +
                "\n Celsius temperature = " + convert();
        return "Error...";
    }
}
