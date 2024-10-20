package com.jaden.dream.trascation;

import com.jaden.dream.proxy.ConnectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * 和事务管理相关的工具类，它包括了，开启事务，提交事务，回滚事务和释放连接
 */
public class MyTransactionManager {

    @Autowired
    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    /**
     * 开启事务
     */
    public void beginTransaction(){
        try{
            connectionUtils.getThreadConnection().setAutoCommit(false);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 提交事务
     */
    public void commitTransaction(){
        try{
            connectionUtils.getThreadConnection().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 回滚事务
     */
    public void rollbackTransaction(){
        try{
            connectionUtils.getThreadConnection().rollback();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 释放连接
     */
    public void release(){
        try{
            connectionUtils.getThreadConnection().close(); // 连接还回连接池
            connectionUtils.removeConnection(); // 解绑
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
