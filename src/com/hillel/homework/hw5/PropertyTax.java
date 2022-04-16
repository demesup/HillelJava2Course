package com.hillel.homework.hw5;

import java.text.DecimalFormat;

public class PropertyTax {
    protected int s;
    protected float taxK;
    protected long propertyTax;

    public static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.##");

    public PropertyTax(int s, float taxK) {
        this.s = s;
        this.taxK = taxK;
    }

    public float count() {
        return s * taxK;
    }

    @Override
    public String toString() {
        return "PropertyTax{" +
                "s=" + s +
                ", taxK=" + taxK +
                ", propertyTax=" + count() +
                '}';
    }

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    public float getTaxK() {
        return taxK;
    }

    public void setTaxK(float taxK) {
        this.taxK = taxK;
    }

    public long getPropertyTax() {
        return propertyTax;
    }

    public void setPropertyTax(long propertyTax) {
        this.propertyTax = propertyTax;
    }
}
