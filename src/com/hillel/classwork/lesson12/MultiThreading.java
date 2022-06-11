package com.hillel.classwork.lesson12;

import com.hillel.classwork.lesson11.FutureTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MultiThreading {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Callable<LocalDateTime> callable = new FutureTest.CurrentDateTime();

        List<Future<LocalDateTime>> futures = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            futures.add(executorService.submit(new FutureTest.CurrentDateTime()));
        }

        for (Future<LocalDateTime> future : futures) {
            System.out.println(future);
        }

        futures.get(3).cancel(true);

        executorService.shutdown();
    }
}
