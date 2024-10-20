package com.jaden.dream.annotation;

import java.lang.reflect.Method;

public class TestAnnotation {
    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("com.jaden.dream.myabstract.Bird");
            Method method = clazz.getMethod("getFly");
            if(method.isAnnotationPresent(MethodInfo.class)){
                System.out.println("Bird类上配置了MethodInfo注解！");
                //获取该元素上指定类型的注解
                MethodInfo operateLog = method.getAnnotation(MethodInfo.class);
                System.out.println("author: " + operateLog.author() +
                        ", version: " + operateLog.version());
            }else{
                System.out.println("Bird类上没有配置MethodInfo注解！");
            }
        }catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
