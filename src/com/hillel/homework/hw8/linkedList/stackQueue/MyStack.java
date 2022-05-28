package com.hillel.homework.hw8.linkedList.stackQueue;

import java.util.LinkedList;


public class MyStack {
    LinkedList<Integer> linkedList = new LinkedList<>();
    int size = 0;

    public MyStack() {
    }

    public void push(int number) {
        linkedList.add(number);
        size++;
    }

    public int pop() {
        if (checkIndex()) return 0;
        int number = peek();
        linkedList.remove(size - 1);
        size--;
        return number;
    }

    public int peek() {
        if (checkIndex()) return 0;
        return linkedList.get(size - 1);
    }

    @Override
    public String toString() {
        return linkedList.toString();
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
