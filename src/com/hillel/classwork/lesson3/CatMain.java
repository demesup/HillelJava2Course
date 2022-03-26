package com.hillel.classwork.lesson3;

public class CatMain {
    public static void main(String[] args) {

        Cat cat = new Cat();
        cat.name = "Vasiliy";
        System.out.println(cat.name + ": " + cat);

        Cat cat1 = new Cat();
        cat1.name = "Murka";
        System.out.println(cat1.name + ": " + cat1);

        Cat cat2 = cat;
        cat2.name = "Snezhok";
        System.out.println(cat2.name + ": " + cat2);

        System.out.println("Are you Vasiliy? - " + cat.name + ": " + cat);

    }
}
