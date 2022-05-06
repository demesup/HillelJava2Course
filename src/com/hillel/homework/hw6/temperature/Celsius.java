package com.hillel.homework.hw6.temperature;

public class Celsius extends Temperature implements ToKelvin, ToFahrenheit {

    public Celsius(float start, String toType) {
        super(start, toType);
    }

    @Override
    public void toFahrenheit() {
        System.out.println("In Fahrenheit temperature = " + DECIMAL_FORMAT.format(start * 9 / 5 + 32) + "F");
    }

    @Override
    public void toKelvin() {
        System.out.println("In Kelvin temperature = " + DECIMAL_FORMAT.format(start + 273.15f) + "K");
    }


    @Override
    public void convert() {
        switch (toType) {
            case "fahrenheit":
                toFahrenheit();
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
        return "Celsius temperature was " + start + "C" ;
    }
}
