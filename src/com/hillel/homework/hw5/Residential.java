package com.hillel.homework.hw5;

public class Residential extends PropertyTax {
    private float averageMonthlyIncome;
    private final float subsistenceMinimum = 2200;

    public long subsidy(float averageMonthlyIncome){
        return (long)(averageMonthlyIncome / subsistenceMinimum / 2 * 15);
    }

    public Residential(int s, int taxK, float averageMonthlyIncome) {
        super(s, taxK);
        this.averageMonthlyIncome = averageMonthlyIncome;
    }

    @Override
    public long count() {
        return s * taxK * subsidy(averageMonthlyIncome);
    }
}
