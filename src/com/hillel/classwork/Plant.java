package com.hillel.classwork;

public class Plant {
    private int height;
    private String family;

    public void photosynthesis(){
        System.out.println("The plant photosynthesize");
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }
}
