package com.jaden.control;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jaden.entity.User;
import com.jaden.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static javax.swing.text.html.HTML.Tag.U;

@RestController
public class MybatisController {
    @Autowired
    public UserMapper userMapper;
    @GetMapping("getUserList")
    public List test (){
        User user = new User();
        user.setId(1);
        return userMapper.selectList(new QueryWrapper<>(user));
    }

}
