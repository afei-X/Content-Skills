package com.afei.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class executorTest {
    
    public  static  void main (String[] args){

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> new StringBuilder().append(1));

            executor.execute(() -> {
                try {
                    System.out.println(executor.awaitTermination(1, MILLISECONDS));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });


        executor.execute(() -> System.out.println("single thread pool test"));



    }
}
