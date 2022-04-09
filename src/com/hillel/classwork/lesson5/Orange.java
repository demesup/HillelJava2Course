package com.hillel.classwork.lesson5;

public class Orange extends Plant{
    private int age;

    public Orange(int age){
        super(300,"Rutaceae");
        this.age=age;
        System.out.println("Create orange");
    }

    public int getAge() {
        return age;
    }

    @Override
    public void photosynthesis() {
        super.photosynthesis();
        age++;
        System.out.println("Orange age " + age);
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Orange{" +
                "age=" + age +
                ", height=" + height +
                ", family='" + family + '\'' +
                '}';
    }
}
