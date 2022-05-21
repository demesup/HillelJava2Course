package com.hillel.classwork.lesson8;

import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {
    public static void main(String[] args) {
        List<Integer> numbers= new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }

        System.out.println(numbers);
    }
}
