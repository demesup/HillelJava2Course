package com.hillel.homework.hw11;

import java.util.ArrayList;
import java.util.List;

public class MultiThreadCounterWithRunnableAndSynchronized {
    private static int COUNTER = 0;

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Counter());
            thread.start();
            threadList.add(thread);
        }

        for (Thread thread : threadList) {
            thread.join();
        }
        System.out.println("counter = " + COUNTER);
    }

    private synchronized static void  nextCounter() {
        COUNTER++;
    }

    private static class Counter implements Runnable {
        @Override
        public void run() {
            Thread current = Thread.currentThread();
            System.out.println("Starting thread: " + current.getName());
            for (int i = 0; i < 1000; i++) {
                nextCounter();
            }
        }
    }
}
