package com.hillel.classwork;

public class Plant {
    private int height;
    private String family;

    public Plant(int height, String family){
        this.height = height;
        this.family = family;
        System.out.println("Create plant");
    }

    @Override
    public String toString() {
        return "Plant{" +
                "height=" + height +
                ", family='" + family + '\'' +
                '}';
    }

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
