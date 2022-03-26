package com.hillel.classwork.lesson3.bird;

public class Bird {
    static int COUNT = 0;

    private String color;

    public Bird(String color) {
        this.color = color;
        COUNT++;
    }

    public static int getCOUNT() {
        return COUNT;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void speak(){
        System.out.println("Chick chirick");
    }

    public String toString() {
        return "Bird: color - " + color;
    }

}
