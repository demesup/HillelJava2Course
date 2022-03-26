package com.hillel.homework;

import java.util.Scanner;

public class Factorials {
    public static int COUNT = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число больше нуля");
        long number = scanner.nextLong();

        if (number > 0 & number <= 20) {
            System.out.println("Факторил с помощью цикла " + factorial(number));
            System.out.println("Факторил с помощью рекурсии " + recursionFactorial(number));
        } else if (number > 20) {
            System.out.println("Факториал слишком большой для типа long");
        } else {
            System.out.println("Число меньше или равно нулю");
        }
    }


    public static long factorial(long x) {
        if (x == 1) {
            return 1;
        }
        long y = 1;
        for (int i = 1; i <= x; i++) {
            y = y * i;
        }
        return y;
    }

    public static long recursionFactorial(long x) {
        if (x == 1) {
            return 1;
        }
        return recursionFactorial(x - 1) * x;
    }

}
