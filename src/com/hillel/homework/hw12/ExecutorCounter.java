package com.hillel.homework.hw12;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ExecutorCounter {
    private static AtomicInteger NUMBER = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println("///////////Callable////////////////");
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<Future<Integer>> futures = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            futures.add(executorService.submit(new CallableCounter()));
        }
        int number = 0;
        for (Future<Integer> f : futures) {
            number += f.get();
        }
        executorService.shutdown();
        System.out.println(number);

        System.out.println("///////////Runnable////////////////");


        ExecutorService executorService1 = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executorService1.submit(new Counter());
        }
        executorService1.shutdown();

        executorService1.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        System.out.println(NUMBER);

    }

    private static class CallableCounter implements Callable<Integer> {

        @Override
        public Integer call() {
            int counter = 0;
            for (int i = 0; i < 1000; i++) {
                ++counter;
            }
            System.out.println(Thread.currentThread().getName());
            return counter;
        }
    }

    private static class Counter implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
            for (int i = 0; i < 1000; i++) {
                NUMBER.getAndIncrement();
            }
        }
    }
}
