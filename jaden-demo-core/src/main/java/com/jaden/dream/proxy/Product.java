package com.jaden.dream.proxy;

public class Product implements IProduct {
    @Override
    public String sell(Float money) {
        System.out.println("代理员交给工厂："+money);
        return "aaa";
    }
    @Override
    public void afterSell() {
        System.out.println("代理员做售后。。");
    }
}
