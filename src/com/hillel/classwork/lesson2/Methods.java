package com.hillel.classwork.lesson2;

public class Methods {
    public static void main(String[] args) {


        System.out.println(sum(3, 4));
        System.out.println(sum(240, 560, 540));


    }

    public static int sum(int x, int y) {
        return x + y;
    }

    public static long sum(long x, long y, long z) {
        return x + y + z;
    }
}
