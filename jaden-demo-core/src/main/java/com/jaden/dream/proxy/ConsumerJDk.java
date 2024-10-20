package com.jaden.dream.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ConsumerJDk {
    public static void main(String[] args) {
    	// 创建一个被代理对象
        final Product product = new Product();
        // 创建一个代理对象，并在InvocationHandler的invoke方法里面，对被代理类的方法做增强
        IProduct proxyProduct = (IProduct) Proxy.newProxyInstance(product.getClass().getClassLoader(), product.getClass().getInterfaces(), new InvocationHandler() {
			// 实现具体的增强操作           
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 获取方法在运行中可能产生的返回值
                Object returnValue = null;
                Float money = (Float) args[0];
                if("sell".equals(method.getName())){
                	// 执行具体的方法
                    returnValue = method.invoke(product, money*0.8F);
                }
                return returnValue;
            }
        });
        System.out.println(proxyProduct.sell(1000F));
    }
}
