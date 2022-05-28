package com.hillel.classwork.lesson10;

import java.util.Arrays;

public class StackTraceTest {
    public static void main(String[] args) {
        method1();
    }

    public static void method1(){
        method2();
        System.out.println(Arrays.toString(Thread.currentThread().getStackTrace()));
    }

    public static void method2(){
        method3();
        System.out.println(Arrays.toString(Thread.currentThread().getStackTrace()));
    }

    public static void method3(){
        method4();
        System.out.println(Arrays.toString(Thread.currentThread().getStackTrace()));
    }

    public static void method4(){
        method5();
        System.out.println(Arrays.toString(Thread.currentThread().getStackTrace()));
    }

    public static void method5(){
        System.out.println(Arrays.toString(Thread.currentThread().getStackTrace()));
    }
}
