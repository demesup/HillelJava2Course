package com.hillel.homework.hw8;

import java.util.LinkedList;

public class MyLinkedList {

    private class Node {
        int element;
        Node prev;

        public Node(int element, Node prev) {
            this.element = element;
            this.prev = prev;
        }
    }

    private int size;
    private Node first;
    private Node last;

    public MyLinkedList() {
    }

    public MyLinkedList(int size) {
        this.size = size;
    }

    public void add(int number) {
        final Node lastNumber = last;
        final Node newNumber = new Node(number, lastNumber);
        last = newNumber;
        size++;
    }

    @Override
    public String toString() {
        return "Try";
    }
    public int[] toArray() {
        int[] result = new int[size];
        int i = 0;
        for (MyLinkedList.Node x = first; x != null; x = x.prev)
            result[i++] = x.element;
        return result;
    }
}
