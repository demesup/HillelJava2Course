package com.hillel.classwork.lesson11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClockManager {

    public static boolean IS_CLOCK_RUN = true;

    public static void main(String[] args) throws InterruptedException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Thread thread = new Thread(new Clock());
        thread.start();

        System.out.println("after clock start");

        Thread.sleep(5000);

        System.out.println("We are awaken");

        System.out.println("Leave the clock working?");

        IS_CLOCK_RUN = Boolean.parseBoolean(reader.readLine());

        if (!IS_CLOCK_RUN){
            thread.interrupt();
        }
    }

    public static class Clock implements Runnable{

        @Override
        public void run() {
            Thread current = Thread.currentThread();
            while (!current.isInterrupted()){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("The clock turned off during the sleep");
                return;
                }
                System.out.println("Tik");
            }
        }
    }
}
