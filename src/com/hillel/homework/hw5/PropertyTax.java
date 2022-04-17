package com.hillel.homework.hw5;

import java.text.DecimalFormat;

public class PropertyTax {
    protected int s;
    protected float taxK;
    protected float propertyTax;
    protected final float incomeWage = 2481;

    public static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.##");

    public PropertyTax(int s, float taxK) {
        this.s = s;
        this.taxK = taxK / 100 * incomeWage;//(% от мин. зарплаты)
    }

    public float count() {
        return s * taxK;
    }

    @Override
    public String toString() {
        return "PropertyTax\n . . . . . . . . . . . . . . " +
                "\n s: " + s +
                "\n taxK:" + DECIMAL_FORMAT.format(taxK) +
                "\n propertyTax:" + DECIMAL_FORMAT.format(count()) +
                "\n_____________________________";
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

    public float getPropertyTax() {
        return propertyTax;
    }

    public void setPropertyTax(float propertyTax) {
        this.propertyTax = propertyTax;
    }
}