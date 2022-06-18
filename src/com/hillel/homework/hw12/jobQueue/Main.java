package com.hillel.homework.hw12.jobQueue;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static AtomicInteger taskCounter = new AtomicInteger(0);


    public static void main(String[] args) throws InterruptedException {
        List<List<Worker>> lists = new ArrayList<>();

        ArrayList<Worker> uaWorkerList = new ArrayList<>();
        uaWorkerList.add(new Worker(123, "Васильев Евстахий Борисович", "+129381832", 4));
        uaWorkerList.add(new Worker(153, "Зиновьева Иоланта Валентиновна", "+3276103543", 5));
        uaWorkerList.add(new Worker(332, "Калинин Артём Валериевич", "+2234234423", 1));

        ArrayList<Worker> ukWorkerList = new ArrayList<>();
        ukWorkerList.add(new Worker(432, "Предыбайло Григорий Анатолиевич", "+2342344234", 5));
        ukWorkerList.add(new Worker(556, "Степанов Мирослав Андреевич", "+6678877777", 2));
        ukWorkerList.add(new Worker(559, "Пупкин Василий Степанович", "+6478215695", 3));


        ArrayList<Worker> roWorkerList = new ArrayList<>();
        roWorkerList.add(new Worker(125, "Воробьёва Анастасия Яковлевна", "+8615943247", 1));
        roWorkerList.add(new Worker(556, "Козлова Наталия Георгьевна", "+9760454628", 3));
        roWorkerList.add(new Worker(336, "Тимофеева Мальта Федотовна", "+4567329532", 5));

        ArrayList<Worker> frWorkerList = new ArrayList<>();
        frWorkerList.add(new Worker(151, "Коновалов Степан Петрович", "+234432334", 4));
        frWorkerList.add(new Worker(439, "Мишина Стелла Богуславовна", "+8531674953", 3));
        frWorkerList.add(new Worker(576, "Агафонова Фаиза Наумовна", "+3647955246", 1));

        lists.add(frWorkerList);
        lists.add(roWorkerList);
        lists.add(uaWorkerList);
        lists.add(ukWorkerList);

        JobQueue jobQueue = new JobQueue();
        Thread worker = new Thread(new Runnable() {
            @Override
            public void run() {
                while (taskCounter.get() < lists.size()) {
                    taskCounter.getAndIncrement();
                    Runnable task = jobQueue.get();
                    task.run();
                }
            }
        });

        worker.start();
        for (List<Worker> list : lists) {
            jobQueue.put(workersSort(list));
        }

        worker.join();
        System.out.println("Sorted list of each country");
        System.out.println(lists);

    }


    public static Runnable workersSort(List<Worker> workers) {
        return new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());

                Collections.sort(workers);

                for (Worker worker : workers) System.out.println(worker.getQualification() + " " + worker.getName());

            }
        };
    }
}
