package com.hillel.classwork.lesson3;

public class EqualsCat {


    public static void main(String[] args) {

        Cat cat = new Cat();
        cat.name = "Vasiliy";
        cat.age = 2;

        Cat cat1 = new Cat();
        cat1.name = "Murka";
        cat1.age = 2;

        Cat cat2 = cat;

        System.out.println(cat);
        System.out.println(cat1);
        System.out.println(cat2);

        if (cat == cat2) {
            System.out.println(cat + " and " + cat2 + " equals by link");
        }else {
            System.out.println(cat + " and " + cat2 + " not equals by link");
        }


        System.out.println("Are you Vasiliy? - " + cat.name + ": " + cat);


    }


}
