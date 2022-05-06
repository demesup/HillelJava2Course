package com.hillel.homework.hw6.temperature;

public class Temperature implements Converter{
    protected float start;
    protected String toType;

    public Temperature(float start, String toType) {
        this.start = start;
        this.toType = toType;
    }

    @Override
    public String toString() {
        return "Temperature{" +
                "start temperature=" + start +
                '}';
    }

    public float getStart() {
        return start;
    }

    public void setStart(float start) {
        this.start = start;
    }

    public String getToType() {
        return toType;
    }

    public void setToType(String toType) {
        this.toType = toType;
    }

    @Override
    public float convert() {
        System.out.println("Converting...");
        return 0;
    }
}
