package com.hillel.classwork.lesson1;

import java.util.Scanner;

public class Grade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input number");
        int grade = scanner.nextInt();

        if (grade >= 1 && grade <= 3) {
            System.out.println("Двоечник");
        } else if (grade > 3 && grade <= 6) {
            System.out.println("Трочшник");
        } else if (grade > 6 && grade <= 9) {
            System.out.println("Хорошист");
        } else if (grade >= 10 && grade <= 12) {
            System.out.println("Отличник");
        } else{
            System.out.println("Error");
        }

    }
}
