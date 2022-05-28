package com.hillel.homework.hw8.linkedList.stackQueue;

import java.util.LinkedList;

public class MyQueue {

    LinkedList<String> linkedList = new LinkedList<>();
    int size = 0;

    public MyQueue() {
    }

    public boolean add(String number) {
        linkedList.add(number);
        size++;
        return true;
    }

    public String poll() {
        if (empty()) return null;
        String str = peek();
        linkedList.remove(0);
        size--;
        return str;
    }

    public String peek() {
        if (empty()) return null;
        return linkedList.get(0);
    }

    @Override
    public String toString() {
        return linkedList.toString();
    }

    public int size() {
        return size;
    }

    public boolean empty(){return size == 0;}
}
