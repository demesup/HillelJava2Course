package com.hillel.homework.hw5;

public class Commercial extends PropertyTax{
    private long earnings;

    public Commercial(int s, int taxK, long earnings) {
        super(s, taxK);
        this.earnings = earnings;
    }

    public long getPropertyTax() {
        if (earnings<100){
            return 0;
        }
        return getTaxK();
    }

    public long getEarnings() {
        return earnings;
    }

    public void setEarnings(long earnings) {
        this.earnings = earnings;
    }
}
