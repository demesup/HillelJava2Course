package com.hillel.homework;

import java.util.Scanner;

public class Factorials {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long number = scanner.nextLong();

        System.out.println(factorial(number));
    }

    public static long factorial(long x) {
        long y = 1;
        for (int i = 1; i <= x; i++) {
            y = y * i;
        }
        return y;
    }

    public static long recursionFactorial(long x) {
        long y = 1;
        for (int i = 1; i <= x; i++) {
            y = y * i;
        }
        return y;
    }

}
