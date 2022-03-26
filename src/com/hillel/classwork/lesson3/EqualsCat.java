package com.hillel.classwork.lesson3;

public class EqualsCat {


    public static void main(String[] args) {

        Cat cat = new Cat();
        cat.name = "Murka";
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

        if (cat.equals(cat1)) {
            System.out.println(cat + " and " + cat1 + " equals by values");
        }else {
            System.out.println(cat + " and " + cat1 + " not equals by values");
        }


        System.out.println("Are you Vasiliy? - " + cat.name + ": " + cat);


    }


}
