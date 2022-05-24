package com.hillel.homework.hw8.linkedListPrev;

import java.util.LinkedList;

public class MainPrev {
    public static void main(String[] args) {

        LinkedListPrev listPrev = new LinkedListPrev();

        listPrev.remove(0);
        listPrev.set(5,56);
        listPrev.get(0);

        listPrev.addFirst(100);
        System.out.println(listPrev.size());

        listPrev.add(2);
        listPrev.add(6);
        listPrev.add(9);
        listPrev.add(56);

        System.out.println(listPrev);
        System.out.println(listPrev.size());

        System.out.println(listPrev.get(2));

        listPrev.set(1, 66);
        listPrev.addFirst(666);
        listPrev.add(5, 44);

        System.out.println(listPrev);

        listPrev.remove(5);
        listPrev.remove(-1);

        System.out.println(listPrev);
    }
}
