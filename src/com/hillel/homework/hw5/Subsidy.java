package com.hillel.homework.hw5;

public class Subsidy {

    private float averageMonthlyIncome;
    private final float subsistenceMinimum = 2200;

    public float subsidy(float averageMonthlyIncome){
        return averageMonthlyIncome / subsistenceMinimum / 2 * 15;
    }
}
