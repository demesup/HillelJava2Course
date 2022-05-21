package com.hillel.classwork.lesson9;

import java.util.TreeSet;

public class PersonMain {
    public static void main(String[] args) {
        TreeSet<Person> people = new TreeSet<>();
        people.add(new Person("Mariana"));
        people.add(new Person("Andrey"));
        people.add(new Person("Anna"));

        for (Person person:people) {
            System.out.println(person);
        }
    }
}
