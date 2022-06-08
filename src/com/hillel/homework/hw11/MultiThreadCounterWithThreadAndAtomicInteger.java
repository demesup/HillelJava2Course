package com.hillel.homework.hw11;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MultiThreadCounterWithThreadAndAtomicInteger {
    private static AtomicInteger COUNTER = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            CounterThread thread = new CounterThread();
            thread.start();
            threadList.add(thread);
        }

        for (Thread thread : threadList) {
            thread.join();
        }
        System.out.println("counter = " + COUNTER);
    }

    private static void nextCounter() {
        COUNTER.getAndIncrement();
    }

    private static class CounterThread extends Thread {
        @Override
        public void run() {
            System.out.println("Starting thread: " + currentThread().getName());
            for (int i = 0; i < 1000; i++) {
                nextCounter();
            }
        }
    }
}
