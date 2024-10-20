package com.jaden.dream.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ConsumerCgLib {
    public static void main(final String[] args) {
    	// 创建一个被代理对象，这里要求必须是final
        final Product product = new Product();
        Product proxyProduct =(Product) Enhancer.create(product.getClass(), new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Float money = (Float) objects[0];
                Object returnValue = null;
                if("sell".equals(method.getName())){
                    returnValue = method.invoke(product, 0.8f * money);
                }else{
                    method.invoke(product,objects);
                }
                return returnValue;
            }
        });
        System.out.println(proxyProduct.sell(1000f));
        product.afterSell();
    }
}
