package com.example.mapper;

import java.util.List;

import com.example.pojo.User;

import org.mybatis.spring.support.SqlSessionDaoSupport;

//Mybatis-plus 通用mapper
public class UserMapperImpl extends SqlSessionDaoSupport implements UserMapper{

    @Override
    public List<User> test1(){
        User user =new User(2,"test","123456");
        insert(user);
        deleteById(2);
        return query();
    }

    @Override
    public List<User> query() {
        return getSqlSession().getMapper(UserMapper.class).query();
    }

    @Override
    public int insert(User user) {
        return getSqlSession().getMapper(UserMapper.class).insert(user);
    }

    @Override
    public int deleteById(int id) {
        return getSqlSession().getMapper(UserMapper.class).deleteById(id);
    }
    
}
