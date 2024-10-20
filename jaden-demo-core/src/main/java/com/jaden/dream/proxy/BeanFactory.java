package com.jaden.dream.proxy;

import com.jaden.dream.trascation.MyTransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Component
public class BeanFactory {

    @Autowired
    /**
     * 由于配置文件有2个AccountService实现类的bean配置，所以要指定beanId才可以自动注入
     * proxyAccountService、accountService
     */
    @Qualifier("accountService")
    private IAccountService iAccountService;

    @Autowired
    MyTransactionManager transactionManager;

	// 通过JDK动态代理实现
    public IAccountService getAccountService() {
        IAccountService proxyIaccountService = (IAccountService) Proxy.newProxyInstance(iAccountService.getClass().getClassLoader(), iAccountService.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object returnValue = null;
                try {
                    transactionManager.beginTransaction();
                    System.out.println("开启事务。。。");
                    System.out.println("执行【"+method.getName()+"】方法。。。");
                    returnValue = method.invoke(iAccountService, args);
                    System.out.println(5/0);
                    transactionManager.commitTransaction();
                    System.out.println("COMMIT事务。。。");
                }catch (Exception e){
                    System.out.println("ROLLBACK事务。。。");
                    transactionManager.rollbackTransaction();
                    e.printStackTrace();
                }finally {
                    transactionManager.release();
                }
                return returnValue;
            }
        });
        return proxyIaccountService;
    }

	// 通过Cglib动态代理实现
	public IAccountService getAccountServiceByCglib() {
        IAccountService proxyAccountServiceByCglib = (IAccountService) Enhancer.create(IAccountService.class, new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Object returnValue = null;
                try {
                    transactionManager.beginTransaction();
                    System.out.println("开启事务。。。");
                    System.out.println("执行【"+method.getName()+"】方法。。。");
                    returnValue = method.invoke(iAccountService, objects);
                    System.out.println(5/0);
                    transactionManager.commitTransaction();
                    System.out.println("COMMIT事务。。。");
                }catch (Exception e){
                    System.out.println("ROLLBACK事务。。。");
                    transactionManager.rollbackTransaction();
                    e.printStackTrace();
                }finally {
                    transactionManager.release();
                }
                return returnValue;            }
        });
        return proxyAccountServiceByCglib;
    }
    
    public void setIAccountService(IAccountService iAccountService) {
        this.iAccountService = iAccountService;
    }
}
