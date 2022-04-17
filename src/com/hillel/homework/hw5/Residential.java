package com.hillel.homework.hw5;

import java.util.Locale;

public class Residential extends PropertyTax {
    private String type;
    private final float livingWage = 2481;
    private final int fixedTax = 25_000;
    private int familyIncome;
    private int residents;

    public Residential(int s, float taxK, String type, int familyIncome, int residents) {
        super(s, taxK);
        this.type = type.toLowerCase(Locale.ROOT).replaceAll(" ", "");
        this.familyIncome = familyIncome;
        this.residents = residents;
    }

    private float subsidy() {
        float subsidy = (float) familyIncome / residents / livingWage / 2 * 15; //Среднемесячный доход на 1 чел / прожиточный минимум / 2 * 15% * 100
        if (subsidy < 100) return subsidy;
        return 100;
    }

    @Override
    protected float count() {
        switch (type) {
            case "flat":
                if (s > 300) {
                    return (s - 60) * taxK * subsidy() / 100 + fixedTax;
                } else if (s > 60) {
                    return (s - 60) * taxK * subsidy() / 100;
                }
            case "house":
                if (s > 500) {
                    return (s - 120) * taxK * subsidy() / 100 + fixedTax;
                } else if (s > 120) {
                    return (s - 120) * taxK * subsidy() / 100;
                }
            default:
                return 0;
        }
    }

    @Override
    public String toString() {
        return "Residential\n . . . . . . . . . . . . . . " +
                "\n space: " + s +
                "\n taxK: " + DECIMAL_FORMAT.format(taxK) +
                "\n type: " + type +
                "\n family income: " + familyIncome +
                "\n residents: " + residents +
                "\n to pay: " + DECIMAL_FORMAT.format(subsidy()) +
                "%\n property total tax: " + DECIMAL_FORMAT.format(count()) +
                "\n_____________________________";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getLivingWage() {
        return livingWage;
    }

    public int getFixedTax() {
        return fixedTax;
    }

    public int getFamilyIncome() {
        return familyIncome;
    }

    public void setFamilyIncome(int familyIncome) {
        this.familyIncome = familyIncome;
    }

    public int getResidents() {
        return residents;
    }

    public void setResidents(int residents) {
        this.residents = residents;
    }
}