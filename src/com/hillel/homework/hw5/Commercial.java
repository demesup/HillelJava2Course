package com.hillel.homework.hw5;

public class Commercial extends PropertyTax {
    private int earnings;

    public Commercial(int s, int earnings) {
        super(s, 1.5f);//для примера
        this.earnings = earnings;
    }

    @Override
    public float count() {
        if (earnings <= 100) {
            return 0;
        }
        return s * taxK;
    }

    @Override
    public String toString() {
        return "Commercial\n . . . . . . . . . . . . . . " +
                "\n earnings: " + earnings +
                "\n space: " + s +
                "\n\b taxK: " + DECIMAL_FORMAT.format(taxK) +
                "\n propertyTax: " + DECIMAL_FORMAT.format(count())+
                "\n_____________________________";
    }

    public int getEarnings() {
        return earnings;
    }

    public void setEarnings(int earnings) {
        this.earnings = earnings;
    }
}