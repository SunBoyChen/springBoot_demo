package com.zhihua.demo_jpa.controller;

import com.zhihua.demo_jpa.entity.UserEntity;
import com.zhihua.demo_jpa.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserJPA userJPA;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<UserEntity> list(){
        List<UserEntity> all = userJPA.findAll();
        return all;
    }

    /**
     * 添加、更新用户方法
     * @param entity
     * @return
     */
    @RequestMapping(value = "/save",method = RequestMethod.GET)
    public UserEntity save(UserEntity entity){
            return userJPA.save(entity);
        }

    /**
     * 删除用户方法
     * @param id 用户编号
     * @return
     */
   /*@RequestMapping(value = "/delete",method = RequestMethod.GET)
    public List<UserEntity> delete(Long id) {
            userJPA.delete(id);
            return userJPA.findAll();
        }*/

}
