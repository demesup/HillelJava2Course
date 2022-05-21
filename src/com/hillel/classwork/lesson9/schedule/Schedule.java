package com.hillel.classwork.lesson9.schedule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Schedule {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input day of week");
        System.out.println(Arrays.toString(DayOfWeeks.values()));
        String day = reader.readLine().toUpperCase().replaceAll(" ", "");
        DayOfWeeks dayOfWeeks = DayOfWeeks.valueOf(day);

        List<Student> students = new ArrayList<>();
        students.add(new Student("Liana", DayOfWeeks.TUESDAY));
        students.add(new Student("Nazar", DayOfWeeks.MONDAY));
        students.add(new Student("Sofiya", DayOfWeeks.WEDNESDAY));
        students.add(new Student("Nikita", DayOfWeeks.THURSDAY));
        students.add(new Student("Andrey", DayOfWeeks.FRIDAY));
        students.add(new Student("Vova", DayOfWeeks.SATURDAY));
        students.add(new Student("Mariana", DayOfWeeks.SUNDAY));

        Map<DayOfWeeks,Student> map = new HashMap<>();
        for (Student student:students) {
            map.put(student.getOnDuty(),student);
        }

        Student onDutyStudent = map.get(dayOfWeeks);
        System.out.println(onDutyStudent.getName() + " is on duty on " + dayOfWeeks);

//
//        for (Student student : students) {
//            System.out.println(student);
//
//            if (dayOfWeeks.equals(student.getOnDuty())) {
//                System.out.println(student.getName() + " is on duty on " + dayOfWeeks);
//            }
//        }


    }
}
