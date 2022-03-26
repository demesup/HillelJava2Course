package com.hillel.homework;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter line");

        String line = scanner.nextLine();

        isPalindrome(line);

//        String s1 = line.replaceAll(" ", "");
//        StringBuilder s2 = new StringBuilder(s1);

//        if (s1.equalsIgnoreCase(s2.reverse().toString())) {
//            System.out.println("The line is palindrome");
//        } else {
//            System.out.println("The line is not palindrome");
//        }


    }

    public static void isPalindrome(String str) {

        if (str.replaceAll(" ", "").equalsIgnoreCase
                (new StringBuilder(str.replaceAll(" ", "")).reverse().toString())) {
            System.out.println("The line is palindrome");
        } else {
            System.out.println("The line is not palindrome");
        }
    }
}
