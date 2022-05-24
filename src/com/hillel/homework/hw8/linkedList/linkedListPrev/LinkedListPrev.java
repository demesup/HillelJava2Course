package com.hillel.homework.hw8.linkedList.linkedListPrev;

import java.util.Arrays;

public class LinkedListPrev {


    private class Node {
        int number;
        Node prev;

        public Node(int number, Node prev) {
            this.number = number;
            this.prev = prev;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "number=" + number +
                    ", prev=" + prev +
                    '}';
        }
    }

    private int size;
    private Node first;
    private Node last;

    public LinkedListPrev() {
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
        for (int i = size - 1; i > index; i--)
            node = node.prev;
        return node;
    }

    public void remove(int indexRemove) {
        if (indexOutBounds(indexRemove)) {
            System.out.println("Error, 000");
            return;
        }
        if (node(indexRemove) == last) {
            node(indexRemove).prev = null;
            last = node(indexRemove - 1);
            return;
        }

        node(indexRemove + 1).prev = node(indexRemove).prev;
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

        node(index + 1).prev = new Node(number, node(index));
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
            first.prev = newNode;
        first = newNode;
        size++;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        int[] result = new int[size];
        int i = size - 1;
        for (Node j = last; j != null; j = j.prev)
            result[i--] = j.number;
        return Arrays.toString(result);
    }
}
