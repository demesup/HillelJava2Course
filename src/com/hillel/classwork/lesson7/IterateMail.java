package com.hillel.classwork.lesson7;

import java.util.ArrayList;
import java.util.List;

public class IterateMail {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList();
        for (int i = 0; i < 10; i++) {
            numbers.add(i + 1);
        }
        System.out.println(numbers);

        for (int i = 0; i < numbers.size(); i++) {
            int j = numbers.size() - i - 1;
            System.out.print(numbers.get(j) + " ");
        }

        for (Integer number : numbers) {
            System.out.print(number + " ");
        }

        System.out.println();

        System.out.println("Does collection contain number 5 : " + numbers.contains(5));
        System.out.println("Does collection contain number 11 : " +numbers.contains(11));

        numbers.remove(8);
        System.out.println(numbers);

        ArrayList<String> words = new ArrayList<>();
        words.add("Hello");
        words.add("Hi");
        words.add("Morning");
        words.add("Evening");

        System.out.println(words);
        words.remove("Hi");
        words.remove(1);
        System.out.println(words);

    }
}
