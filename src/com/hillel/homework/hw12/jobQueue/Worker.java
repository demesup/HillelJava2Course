package com.hillel.homework.hw12.jobQueue;

public class Worker implements Comparable<Worker>{
    private int id;
    private String name;
    private String phone;
    private int qualification;

    public Worker(int id, String name, String phone, int qualification) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.qualification = qualification;
    }

    @Override
    public String toString() {
        return "\nWorker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", qualification= " + qualification +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public int getQualification() {
        return qualification;
    }

    @Override
    public int compareTo(Worker o) {
        return Integer.compare(qualification, o.getQualification());
    }
}