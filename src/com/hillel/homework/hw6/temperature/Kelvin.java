package com.hillel.homework.hw6.temperature;

public class Kelvin extends Temperature implements ToFahrenheit, ToCelsius {

    public Kelvin(float start, String toType) {
        super(start, toType);
    }

    @Override
    public void toCelsius() {
        System.out.println("In Celsius temperature = " + DECIMAL_FORMAT.format(start - 273.15f) + "C");
    }

    @Override
    public void toFahrenheit() {
        System.out.println("In Fahrenheit temperature = " +
                DECIMAL_FORMAT.format((start - 273.15f) * 9 / 5 + 32) + "F");
    }

    @Override
    public void convert() {
        switch (toType) {
            case "fahrenheit":
                toFahrenheit();
                break;
            case "celsius":
                toCelsius();
                break;
            default:
                System.out.println("Error...");
        }
    }

    @Override
    public String toString() {
        convert();
        return "Kelvin temperature was " + start + "K\n";
    }
}
