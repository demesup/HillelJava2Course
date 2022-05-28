package com.hillel.homework.hw8.linkedList.stackQueue;


import java.util.Arrays;

public class MyStackArray {
    private int size = 0;
    private int[] numbers = new int[size];

    public MyStackArray() {
    }

    public void push(int number) {
        int[] numbersNew = new int[size + 1];
        System.arraycopy(numbers, 0, numbersNew, 0, numbers.length);
        numbers = numbersNew;

        numbers[size] = number;
        size++;
    }

    public int pop() {
        if (checkIndex()) return 0;
        int number = peek();
        int[] numbersNew = new int[size - 1];
        System.arraycopy(numbers, 0, numbersNew, 0, numbersNew.length);
        numbers = numbersNew;
        size--;
        return number;
    }

    public int peek() {
        if (checkIndex()) return 0;
        return numbers[size - 1];
    }

    @Override
    public String toString() {
        return Arrays.toString(numbers);
    }

    public int size() {
        return size;
    }

    public boolean empty() {
        return size == 0;
    }

    private boolean checkIndex() {
        if (empty()) {
            System.out.println("Error, return statement = 0");
            return true;
        }
        return false;
    }
}
