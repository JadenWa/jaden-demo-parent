package com.jaden.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "your_index_name")
public class YourEntity {
    @Id
    private String id;
    // 其他属性
}