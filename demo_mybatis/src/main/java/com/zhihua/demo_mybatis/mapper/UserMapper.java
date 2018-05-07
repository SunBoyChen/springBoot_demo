package com.zhihua.demo_mybatis.mapper;

import com.zhihua.demo_mybatis.entity.UserEntity;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import static org.apache.ibatis.jdbc.Null.TIMESTAMP;
import static org.apache.ibatis.type.JdbcType.VARCHAR;
@Mapper
public interface UserMapper {

    int insert(UserEntity user);

    UserEntity selectByPrimaryKey(int id);
}
