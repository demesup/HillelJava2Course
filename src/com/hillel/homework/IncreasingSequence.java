package com.hillel.homework;

import java.util.Arrays;
import java.util.Scanner;

public class IncreasingSequence {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите количество чисел ");


        int length = scanner.nextInt();

        if (length > 1) {
            int[] array = new int[length];
            for (int i = 0; i < array.length; i++) {
                System.out.printf("Введите %d число \n ", i);
                array[i] = scanner.nextInt();
            }

            System.out.println(Arrays.toString(array));


            if (increasingSequence(array)) {
                System.out.println("Массив является возрастающей последовательностью");
            } else {
                System.out.println("Массив не является возрастающей последовательностью");
            }
        } else {
            System.out.println("Для последовательности нужно больше 2 чисел");
        }



    }
    public static boolean increasingSequence ( int[] array){

        for (int i = 1; i < array.length; i++) {
            if (array[i] <= array[i - 1]) {
                return false;
            }
        }
        return true;

    }
}
