package com.example.mapper;

import java.util.List;

import com.example.pojo.User;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class UserMapperImpl2 extends SqlSessionDaoSupport implements UserMapper{

    @Override
    public List<User> query() {
        return getSqlSession().getMapper(UserMapper.class).query();
    }
    
}
