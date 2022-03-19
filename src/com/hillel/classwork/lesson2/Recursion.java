package com.hillel.classwork.lesson2;

public class Recursion {
    public static void main(String[] args) {
        recursion(10);
    }

    public static int COUNT = 0;
    public static int LIMIT = 10;

    public static void recursion() {
        System.out.println("Hello world");
        COUNT++;

        if (COUNT <= LIMIT) {
            recursion();
        }

    }

    public static void recursion(int count) {
        System.out.println("Hello world " + count);

        if (count>0){
            recursion(count-1);
        }
    }

}
