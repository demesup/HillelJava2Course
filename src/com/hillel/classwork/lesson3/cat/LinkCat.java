package com.hillel.classwork.lesson3.cat;

public class LinkCat {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.age=10;

        System.out.println("Before change " + cat.age);

        changeCat(cat);

        System.out.println("After method " + cat.age);
    }

    public static void changeCat(Cat cat){
        System.out.println("Before change " + cat.age);

        cat.age = 20;

        System.out.println("After method " + cat.age);
    }
}
