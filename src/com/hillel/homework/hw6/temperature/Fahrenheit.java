package com.hillel.homework.hw6.temperature;

public class Fahrenheit extends Temperature implements ToCelsius, ToKelvin {

    public Fahrenheit(float start, String toType) {
        super(start, toType);
    }

    @Override
    public void toCelsius() {
        System.out.println("In Celsius temperature = " + DECIMAL_FORMAT.format((start - 32) * 5 / 9) + "C");
    }

    @Override
    public void toKelvin() {
        System.out.println("In Kelvin temperature = " + DECIMAL_FORMAT.format((start - 32) * 5 / 9 + 273.15f) + "K");
    }

    @Override
    public void convert() {
        switch (toType) {
            case "celsius":
                toCelsius();
                break;
            case "kelvin":
                toKelvin();
                break;
            default:
                System.out.println("Error...");
        }
    }

    @Override
    public String toString() {
        convert();
        return "Fahrenheit temperature was " + start + "F\n";
    }
}
