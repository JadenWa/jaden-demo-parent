package com.jaden.dream;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
 
public class CallableExample {
 
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(3); // 创建线程池
 
        Callable<Integer> task1 = () -> {
            System.out.println("Task 1 is running...");
            return 1;
        };
 
        Callable<Integer> task2 = () -> {
            System.out.println("Task 2 is running...");
            return 2;
        };
 
        Callable<Integer> task3 = () -> {
            System.out.println("Task 3 is running...");
            return 3;
        };
 
        // 提交任务并获得Future对象
        Future<Integer> future1 = executor.submit(task1);
        Future<Integer> future2 = executor.submit(task2);
        Future<Integer> future3 = executor.submit(task3);
 
        // 获取任务结果
        Integer result1 = future1.get();
        Integer result2 = future2.get();
        Integer result3 = future3.get();
 
        System.out.println("Task 1 result: " + result1);
        System.out.println("Task 2 result: " + result2);
        System.out.println("Task 3 result: " + result3);
 
        // 关闭线程池
        executor.shutdown();
    }
}