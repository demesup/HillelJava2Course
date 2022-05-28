package com.hillel.classwork.lesson10;

import java.util.Arrays;

public class StackTraceTest {
    public static void main(String[] args) {
        method1();
    }

    public static void method1() {
        method2();
        System.out.println(Arrays.toString(Thread.currentThread().getStackTrace()));
    }

    public static void method2() {
        method3();
        System.out.println(Arrays.toString(Thread.currentThread().getStackTrace()));
    }

    public static void method3() {
        method4();
        System.out.println(Arrays.toString(Thread.currentThread().getStackTrace()));
    }

    public static void method4() {
        try {
            method5();
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }

        System.out.println(Arrays.toString(Thread.currentThread().getStackTrace()));

        System.out.println("after method5");
    }

    public static void method5() {
        System.out.println(Arrays.toString(Thread.currentThread().getStackTrace()));
        int[] arr = new int[5];
        System.out.println(arr[5]);

        System.out.println("after");
    }
}
