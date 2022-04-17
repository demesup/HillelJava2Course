package com.hillel.homework.hw5;

public class Industrial extends PropertyTax {
    public Industrial(int s) {
        super(s, 0);// по закону Украины производ. недвижимость не является объектом налогооблажения
    }

    @Override
    public String toString() {
        return "Industrial\n . . . . . . . . . . . . . . " +
                "\n space: " + s +
                "\n taxK: 0" +
                "\n propertyTax: 0 " +
                "\nПо закону Украины производ. недвижимость не является объектом налогооблажения" +
                "\n_____________________________";
    }
}