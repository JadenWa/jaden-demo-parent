package com.jaden.dream.myabstract;

import java.util.concurrent.Callable;

public class MultiBird extends Bird implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println( Thread.currentThread().getId()+" is running");
        Thread.sleep(3000);
        System.out.println(2);
        return 1;
    }
}
