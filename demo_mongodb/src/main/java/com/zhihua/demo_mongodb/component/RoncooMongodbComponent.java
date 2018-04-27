package com.zhihua.demo_mongodb.component;

import com.zhihua.demo_mongodb.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class RoncooMongodbComponent {

    @Autowired
    private MongoTemplate mongoTemplate;


    public void save(){
        UserEntity user = new UserEntity();
        user.setAddress("sz");
        user.setAge(25);
        user.setBir(new Date());
        user.setId(2L);
        user.setName("之花");
        user.setPwd("123");
        mongoTemplate.insert(user);
    }


    public void deleteById(long id) {
        Criteria criteria = Criteria.where("id").in(id);
        Query query = new Query(criteria);
        mongoTemplate.remove(query, UserEntity.class);
    }


    public void updateById(UserEntity user) {
        Criteria criteria = Criteria.where("id").in(user.getId());
        Query query = new Query(criteria);
        Update update = new Update();
        update.set("name", user.getName());
        update.set("age", user.getAge());
        update.set("pwd",user.getPwd());
        update.set("address",user.getAddress());
        mongoTemplate.updateMulti(query, update, UserEntity.class);
    }


    public UserEntity selectById(long id) {
        Criteria criteria = Criteria.where("id").in(id);
        Query query = new Query(criteria);
        return mongoTemplate.findOne(query, UserEntity.class);
    }
}
