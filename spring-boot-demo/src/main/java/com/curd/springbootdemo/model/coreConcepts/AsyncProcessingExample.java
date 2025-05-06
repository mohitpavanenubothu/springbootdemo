package com.curd.springbootdemo.model.coreConcepts;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncProcessingExample {
    public static void main(String[] args) {
        // Create a CompletableFuture instance
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            // Simulate an asynchronous operation
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "Asynchronous operation completed";
        });
        // Handle the result of the asynchronous operation
        future.thenAccept(System.out::println);

        // Continue with other operations without blocking
        System.out.println("Main thread continues execution...");

        // Create an ExecutorService instance
        ExecutorService executor = Executors.newCachedThreadPool();

        // Submit an asynchronous task
        executor.submit(() -> {
            // Simulate an asynchronous operation
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Asynchronous operation completed");
        });

        // Continue with other operations without blocking
        System.out.println("Main thread continues execution...");

        // Shut down the ExecutorService instance
        executor.shutdown();
    }
}
