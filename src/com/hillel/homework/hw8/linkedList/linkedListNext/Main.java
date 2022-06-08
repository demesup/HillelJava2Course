package com.hillel.homework.hw8.linkedList.linkedListNext;

public class Main {
    public static void main(String[] args) {

        MyLinkedList myLinkedList = new MyLinkedList();

        myLinkedList.remove(0);
        myLinkedList.set(5,56);
        System.out.println(myLinkedList.get(0));

        myLinkedList.addFirst(100);
        System.out.println(myLinkedList.size());

        myLinkedList.add(2);
        myLinkedList.add(6);
        myLinkedList.add(9);
        myLinkedList.add(56);

        System.out.println(myLinkedList);
        System.out.println(myLinkedList.size());

        System.out.println(myLinkedList.get(2));

        myLinkedList.addFirst(666);
        myLinkedList.set(1, 66);
        myLinkedList.add(0,75);
        myLinkedList.add(5, 44);
        myLinkedList.add(15, 44);

        System.out.println(myLinkedList);

        myLinkedList.remove(5);
        myLinkedList.remove(-1);

        System.out.println(myLinkedList);
    }
}
