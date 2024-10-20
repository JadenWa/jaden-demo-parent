package com.jaden.dream;

import com.jaden.dream.myabstract.Bird;
import com.jaden.dream.myabstract.MultiBird;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyDream {
    public static void main(String[] args) throws Exception {
        System.out.println( Thread.currentThread().getId()+" is running");
        //byte short int long  float double char boolean
        float i=5/2;
        System.out.println(i);
        Bird bird = new Bird();
        bird.getFly();
        bird.fly();
        bird.setFly(" 翅膀");
        bird.fly();
        //
        MultiBird multiBird = new MultiBird();

        ExecutorService executor = Executors.newFixedThreadPool(3); // 创建线程池
        executor.submit(multiBird);
        executor.submit(multiBird);
        executor.submit(multiBird);
        executor.shutdown();
        System.out.println("ending main task");

    }
}
