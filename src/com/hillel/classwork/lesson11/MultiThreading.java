package com.hillel.classwork.lesson11;

import java.util.ArrayList;
import java.util.List;

public class MultiThreading {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Thread " + Thread.currentThread().getName());

        List<Thread> threads = new ArrayList<>();

        System.out.println("Before sleep main");
        Thread.sleep(2000);
        System.out.println("After sleep main");

        for (int i = 0; i < 10; i++) {
//            Printer printer = new Printer("my printer " + i);
//            Thread thread = new Thread(printer);
//            thread.start();
            PrinterThread thread = new PrinterThread();
            thread.start();
            threads.add(thread);
        }

        System.out.println("Middle Thread " + Thread.currentThread().getName());

        for (Thread thread: threads) {
            thread.join();
        }

        System.out.println("Thread " + Thread.currentThread().getName());

    }

    public static class Printer implements Runnable {

        private String name;

        public Printer(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("Thread " + Thread.currentThread().getName());
            System.out.println("I`m " + this.name);
        }
    }

    public static class PrinterThread extends Thread{

        @Override
        public void run() {
            System.out.println("PrinterThread prints message " + currentThread().getName());

            System.out.println("Before sleep " + currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("After sleep " + currentThread().getName());

        }
    }
}
