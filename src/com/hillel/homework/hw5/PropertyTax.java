package com.hillel.homework.hw5;

public class PropertyTax {
    protected int s;
    protected int taxK;
    protected long propertyTax;

    public PropertyTax(int s, int taxK) {
        this.s = s;
        this.taxK = taxK;
    }

    public long count() {
        return s * taxK;
    }

    @Override
    public String toString() {
        return "PropertyTax{" +
                "s=" + s +
                ", taxK=" + taxK +
                ", propertyTax=" + getPropertyTax() +
                '}';
    }

    public int getS() {
        return s;
    }

    public int getTaxK() {
        return taxK;
    }

    public long getPropertyTax() {
        return propertyTax;
    }
}
