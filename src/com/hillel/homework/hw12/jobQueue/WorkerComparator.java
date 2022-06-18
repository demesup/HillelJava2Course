package com.hillel.homework.hw12.jobQueue;

import java.util.Comparator;

public class WorkerComparator implements Comparator<Worker> {
    @Override
    public int compare(Worker o1, Worker o2) {
           return Integer.compare(o1.getQualification(), o2.getQualification());
    }
}
