package com.hillel.homework.hw5;

import java.text.DecimalFormat;
import java.util.Locale;

public class Residential extends PropertyTax {
    private String type;
    private float subsidy;
    private final float livingWage = 2481;
    private final int fixedTax = 25_000;
    private int familyIncome;
    private int residents;

    public Residential(int s, float taxK, String type, int familyIncome, int residents) {
        super(s, taxK);
        this.type = type.toLowerCase(Locale.ROOT).replaceAll(" ", "");
        this.familyIncome = familyIncome;
        this.residents = residents;
        this.subsidy = subsidy();
    }

    private float subsidy() {
        return 100-(familyIncome / residents / livingWage / 2 * 15);
    }

    @Override
    public float count() {
        switch (type) {
            case "flat":
                if (s > 300) {
                    return (s - 60) * taxK + fixedTax;
                } else if (s > 60) {
                    return (s - 60) * taxK * subsidy / 100;
                }
            case "house":
                if (s > 500) {
                    return (s - 120) * taxK + fixedTax;
                } else if (s > 120) {
                    return (s - 120) * taxK * subsidy / 100;
                }
            default:
                return 0;
        }
    }

    @Override
    public String toString() {
        if ((type.equals("flat") && s > 60)||(type.equals("house") && s > 120)){ return "Residential" +
                "\n space: "  + s +
                "\n taxK: " + taxK +
                "\n type: " + type +
                "\n family income: " + familyIncome +
                "\n residents: " + residents +
                "\n subsidy covers: " + DECIMAL_FORMAT.format(subsidy) +
                "%\n property total tax: " + DECIMAL_FORMAT.format(count() / subsidy() * 100) +
                "\n property tax considering subsidy: " + DECIMAL_FORMAT.format(count()) ;
        }
        return "Residential" +
                "\n space: "  + s +
                "\n taxK: " + taxK +
                "\n type: " + type +
                "\n family income: " + familyIncome +
                "\n residents: " + residents +
                "\n property total tax: " + DECIMAL_FORMAT.format(count() / subsidy() * 100) ;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getSubsidy() {
        return subsidy;
    }

    public void setSubsidy(float subsidy) {
        this.subsidy = subsidy;
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
