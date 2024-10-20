package com.jaden.dream.datasorce;


import com.jaden.dream.proxy.ConnectionUtils;
import com.jaden.dream.trascation.MyTransactionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {
    @Bean
    MyTransactionManager myTransactionManager(){
        return new MyTransactionManager();
    }

    @Bean
    ConnectionUtils connectionUtils(){
        return new ConnectionUtils();
    }

}
