package com.hillel.classwork.lesson11;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<FutureTask<LocalDateTime>> futureTaskList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Callable<LocalDateTime> callable = new CurrentDateTime();
            FutureTask<LocalDateTime> futureTask = new FutureTask<>(callable);
            futureTaskList.add(futureTask);
            new Thread(futureTask).start();

        }
        for (FutureTask<LocalDateTime> futureTask : futureTaskList) {
            System.out.println(futureTask.get());
        }

    }

    public static class CurrentDateTime implements Callable<LocalDateTime> {
        @Override
        public LocalDateTime call() throws Exception {
            LocalDateTime now = LocalDateTime.now();
            System.out.println("Date for " + Thread.currentThread().getName() + ": " + now);
            return now;
        }
    }
}
