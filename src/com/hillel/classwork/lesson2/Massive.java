package com.hillel.classwork.lesson2;

import java.util.Arrays;

public class Massive {
    public static void main(String[] args) {
        int[] array = new int[10];

        for (int i = 0; i < 10; i++) {
            array[i] = i;
        }
        System.out.println(Arrays.toString(array));

    }
}
