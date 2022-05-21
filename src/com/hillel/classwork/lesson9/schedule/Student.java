package com.hillel.classwork.lesson9.schedule;

public class Student {
    private String name;
    private DayOfWeeks onDuty;

    public Student(String name, DayOfWeeks scheduleAt) {
        this.name = name;
        this.onDuty = scheduleAt;
    }

    public String getName() {
        return name;
    }

    public DayOfWeeks getOnDuty() {
        return onDuty;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", scheduleAt=" + onDuty +
                '}';
    }
}
