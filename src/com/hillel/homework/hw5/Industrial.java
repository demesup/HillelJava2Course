package com.hillel.homework.hw5;

public class Industrial extends PropertyTax{
    public Industrial(int s) {
        super(s, 0);// по закону Украины производ. недвижимость не является объектом налогооблажения
    }

    @Override
    public String toString() {
        return "Industrial" +
                "\n space: " + s +
                "\n taxK: " + taxK +
                "\n propertyTax: " + count() +
                " по закону Украины производ. недвижимость не является объектом налогооблажения";
    }

}
