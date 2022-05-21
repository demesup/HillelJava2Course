package com.hillel.classwork.lesson9.bird;

import java.util.Comparator;
import java.util.TreeSet;

public class BirdMain {
    public static void main(String[] args) {

        Comparator<Bird> comparator = new BirdColorLenghtComparator();
        TreeSet<Bird> birds = new TreeSet<>(comparator.reversed());
        birds.add(new Bird("красный"));
        birds.add(new Bird("синий"));
        birds.add(new Bird("yellow"));
        System.out.println(birds);

    }
}
