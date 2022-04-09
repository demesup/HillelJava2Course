package com.hillel.classwork.lesson5;

public class Orange extends Plant{
    private int age;

    public Orange(int age){
        super(300,"Rutaceae");
        this.age=age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public void photosynthesis() {
        super.photosynthesis();
    }

    public void setAge(int age) {
        this.age = age;
    }
}
