package com.zhihua.demo_mybatis.controller;

import com.zhihua.demo_mybatis.entity.UserEntity;
import com.zhihua.demo_mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("web")
public class WebController {
    @Autowired
    private UserMapper mapper;

    @RequestMapping("save")
    public String save(){
        UserEntity user = new UserEntity();
        user.setAddress("12344z");
        user.setAge(13);
        user.setBir(new Date());
        user.setName("ls");
        user.setPwd("1234");
        mapper.insert(user);
        return "succes";
    }

    @RequestMapping("find")
    public  UserEntity find(){
        UserEntity user = mapper.selectByPrimaryKey(5);
        System.out.println(user.getName() + "  " + user.getAddress());
        return user;
    }

}
