package com.theforest.practice.concurrency.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolDemo {
    public static void main(String[] args) {
        int cores = Runtime.getRuntime().availableProcessors();
        long start = System.currentTimeMillis();

        ExecutorService executorService = Executors.newFixedThreadPool(100);
        try {
            for (int i = 0; i < 100; i++) {
                executorService.submit(new GenerateRandomIntegerTask());
            }
        } finally {
            executorService.shutdown();
            long end = System.currentTimeMillis();
            long duration = end - start;
            System.out.println("Processed in: " + duration + " ms");
        }
    }

}
