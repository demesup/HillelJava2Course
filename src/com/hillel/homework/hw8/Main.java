package com.hillel.homework.hw8;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList();
        list.add(50);
        list.add(60);
        System.out.println(list);

        MyLinkedList myLinkedList = new MyLinkedList();

        myLinkedList.add(56);

    }
}
