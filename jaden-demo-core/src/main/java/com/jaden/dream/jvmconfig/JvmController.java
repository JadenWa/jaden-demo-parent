package com.jaden.dream.jvmconfig;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.concurrent.*;

@RestController
public class JvmController {
    @GetMapping("jvmTest")
    public void test (){
        ArrayList<byte[]> list = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            byte[] arr = new byte[1024 * 100];//100KB
            list.add(arr);
            try {
                Thread.sleep(120);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @GetMapping("jvmThreadTest")
    public String testThread () {
        Future<Integer> future1;
        Future<Integer> future2;
        Future<Integer> future3;
        // 创建线程池
        ExecutorService executor = null;
        try {
            executor = Executors.newFixedThreadPool(3);
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
            future1 = executor.submit(task1);
            future2 = executor.submit(task2);
            future3 = executor.submit(task3);

            // 获取任务结果
            try {
                Integer result1 = future1.get();
                Integer result2 = future2.get();
                Integer result3 = future3.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }

        } finally {
            // 关闭线程池
            executor.shutdown();
        }


        return "finish";
    }
}
