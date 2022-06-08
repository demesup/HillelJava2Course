package com.hillel.homework.hw8.linkedList.linkedListNext;

import java.util.Arrays;

public class MyLinkedList {

    private class Node {
        int number;
        Node next = null;

        public Node(int number) {
            this.number = number;
        }

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
        try {
            return node(indexGet).number;
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e.getMessage() + " / return statement = -1");
            return -1;
        }
    }

    public void set(int indexSet, int number) {
        try {
            node(indexSet).number = number;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private Node node(int index) {
        Node node = first;
        for (int i = 0; i < index; i++)
            node = node.next;
        return node;
    }

    public void remove(int indexRemove) {
        try {
            if (indexOutBounds(indexRemove)) throw new Exception("Wrong index");

            if (node(indexRemove) == node(size - 1)) {
                node(indexRemove - 1).next = null;
                return;
            }
            node(indexRemove - 1).next = node(indexRemove).next;
            size--;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void add(int number) {
        if (size == 0) {
            first = new Node(number);
            last = first;
            size++;
            return;
        }
        Node lastNumber = last;
        last = new Node(number);
        lastNumber.next = last;
        size++;
    }

    public void add(int index, int number) {
        try {
            if (indexOutBounds(index)) throw new Exception("Wrong index");

            if (index == 0) {
                addFirst(75);
                return;
            }
            node(index - 1).next = new Node(number, node(index));
            size++;
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }

    }

    public void addFirst(int number) {
        if (size == 0) {
            add(number);
            return;
        }
        first = new Node(number, first);
        size++;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if (first == null) return null;
        int[] result = new int[size];
        int i = 0;
        for (Node node = first; i < size; node = node.next) {
            result[i] = node.number;
            i++;
        }
        return Arrays.toString(result);
    }
}

