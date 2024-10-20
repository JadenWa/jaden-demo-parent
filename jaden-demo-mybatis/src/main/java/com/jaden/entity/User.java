package com.jaden.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("user")
@Data
public class User {
    public Integer id;
    public String userid;
    public String username;
    public String age;
}
