package com.hillel.classwork.lesson2;

import java.util.Scanner;

public class StringName {
    public static void main(String[] args) {
        String str = "Hello";

        System.out.println(str.hashCode());
        System.out.println(str);

        String str2 = new String("Hello");
        System.out.println(str2.hashCode());
        System.out.println(str2);

        str += str2;
        System.out.println(str);

        StringBuilder builder = new StringBuilder("1");

        builder.append(2);
        builder.append(true);
        builder.append("test");

        String s = builder.toString();

        System.out.println(s);
    }
}
