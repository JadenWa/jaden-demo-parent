package com.jaden.dream.datasorce;

import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;

public class JdbcTemplateManager {
    @Autowired
    DataSource dataSource;

   /* @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource);
    }*/
}
