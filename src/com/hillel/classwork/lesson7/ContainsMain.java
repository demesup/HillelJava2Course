package com.hillel.classwork.lesson7;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ContainsMain {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter word or stop: ");

        try {
            while (!scanner.hasNext("stop")) {
                words.add(scanner.nextLine().toLowerCase(Locale.ROOT).trim());
            }
        } catch (Exception e) {
            System.out.println("Try correct format");
            System.exit(1);
        }

        if (words.contains("war")) {
            System.out.println("Banned word on at line " + words.indexOf("war"));
        }

    }
}
