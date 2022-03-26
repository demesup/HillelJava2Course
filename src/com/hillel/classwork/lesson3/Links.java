package com.hillel.classwork.lesson3;

public class Links {

    public static void main(String[] args) {

        int number = 10;

        System.out.println("Before change " + number);

        changeNumber(number);

        System.out.println("After method " + number);

    }

    public static void changeNumber(int n) {
        System.out.println("Got number " + n);

        n=20;

        System.out.println("After change " + n);
    }
}
