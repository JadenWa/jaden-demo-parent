package com.jaden.dream.jvmconfig;

import java.util.ArrayList;

public class GCTest {
    public static void main(String[] args) {
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
}