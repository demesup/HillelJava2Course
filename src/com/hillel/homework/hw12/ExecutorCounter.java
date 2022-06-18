package com.hillel.homework.hw12;

import java.util.concurrent.*;

public class ExecutorCounter {

    private static int COUNTER = 0;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("///////////Callable////////////////");
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        for (int i = 0; i < 10; i++) {
            executorService.submit(new CallableCounter());
        }

        executorService.shutdown();

        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        System.out.println(COUNTER);

        System.out.println("///////////Runnable////////////////");
        COUNTER = 0;

        ExecutorService executorService1 = Executors.newFixedThreadPool(1);
        for (int i = 0; i < 10; i++) {
            executorService1.submit(new Counter());
        }

        executorService1.shutdown();

        executorService1.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        System.out.println(COUNTER);

    }

    private static void nextCounter() {
        COUNTER++;
    }

    private static class CallableCounter implements Callable<Integer>{

        @Override
        public Integer call() {
            for (int i = 0; i < 1000; i++) {
                COUNTER++;
            }
            return COUNTER;
        }
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
