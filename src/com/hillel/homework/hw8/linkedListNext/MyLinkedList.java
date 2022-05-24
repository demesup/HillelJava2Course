package com.hillel.homework.hw8.linkedListNext;

import java.util.Arrays;

public class MyLinkedList {

    private class Node {
        int number;
        Node next;

        public Node(int number, Node next) {
            this.number = number;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "number=" + number +
                    ", next=" + next +
                    '}';
        }
    }

    private int size;
    private Node first;
    private Node last;

    public MyLinkedList() {
    }

    private boolean indexOutBounds(int index) {
        return index >= size || index < 0;
    }

    public int get(int indexGet) {
        if (size == 0) {
            System.out.println("Error, 0");
            return 0;
        }

        if (indexOutBounds(indexGet)) {
            System.out.print("Error, 0");
            return 0;
        }

        return node(indexGet).number;

    }

    public void set(int indexSet, int number) {
        if (indexOutBounds(indexSet)) {
            System.out.println("Error, 000");
            return;
        }

        node(indexSet).number = number;
    }

    private Node node(int index) {
        Node node = last;
        for (int i = index; i > size - 1; i--)
            node = node.next;
        return node;
    }

    public void remove(int indexRemove) {
        if (indexOutBounds(indexRemove)) {
            System.out.println("Error, 000");
            return;
        }
        if (node(indexRemove) == last) {
            node(indexRemove - 1).next = null;
            last = node(indexRemove - 1);
            return;
        }

        node(indexRemove - 1).next = node(indexRemove).next;
        size--;
    }

    public void add(int number) {
        Node lastNumber = last;
        Node newNumber = new Node(number, lastNumber);
        last = newNumber;
        if (size == 0) first = newNumber;
        size++;
    }

    public void add(int index, int number) {
        if (indexOutBounds(index)) {
            System.out.println("Error, 000");
            return;
        }
        if (index == size - 1) {
            add(number);
            return;
        }
        if (index == 0) {
            add(number);
            return;
        }

        node(index - 1).next = new Node(number, node(index));
        size++;
    }

    public void addFirst(int number) {
        if (size == 0) {
            add(number);
            return;
        }
        Node newNode = new Node(number, null);
        if (first == null)
            last = newNode;
        else
            first.next = newNode;
        first = newNode;
        size++;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        int[] result = new int[size];
        int i = 0;
        for (Node j = first; j != null; j = j.next)
            result[i++] = j.number;
        return Arrays.toString(result);
    }
}

