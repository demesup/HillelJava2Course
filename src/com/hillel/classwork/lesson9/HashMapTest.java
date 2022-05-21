package com.hillel.classwork.lesson9;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class HashMapTest {

    public static void main(String[] args) {
        HashMap<String, Integer> employees= new HashMap<>();
        employees.put("HR", 20);
        employees.put("DEV", 50);
        employees.put("MANAGEMENT", 10);
        employees.put(null, 1);

        System.out.println(employees.get("HR"));

        Set<String> departments = new HashSet<>();
        departments.add("HR");
        departments.add("DEV");
        departments.add("MANAGEMENT");

        for (String department: departments) {
            System.out.println(department);
        }

        departments.remove("DEV");
        for (String department: departments) {
            System.out.println(department);
        }

        if (departments.contains("DEV")){
            System.out.println("Developers are here");
        } else {
            System.out.println("Developers are not here");
        }
    }
}
