package com.jaden.dream.proxy;

import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * 连接工具类，它用于从数据源获取一个连接，并实现和线程的绑定
 */
public class ConnectionUtils {
    private ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

    @Autowired
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 获取当前线程上的连接
     */
    public Connection getThreadConnection(){
        try {
            //先从ThreadLocal上获取
            Connection conn = tl.get();
            // 2.判断当前线程上是否有链接
            if(conn == null){
                // 3.从数据源中获取一个连接，并且存入THreadLocal中
                conn = dataSource.getConnection();
                tl.set(conn);
            }
            return conn;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 把链接和线程解绑
     */
    public void removeConnection(){
        tl.remove();
    }
}

