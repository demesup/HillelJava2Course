package com.hillel.homework.hw12.jobQueue;

import java.util.ArrayList;

public class JobQueue {
    ArrayList<Runnable> jobs = new ArrayList<>();

    public synchronized Runnable get() {
        while (jobs.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        Runnable task = jobs.get(0);
        jobs.remove(task);
        return task;
    }

    public synchronized void put(Runnable task) {
        jobs.add(task);
        notifyAll();
    }

}
