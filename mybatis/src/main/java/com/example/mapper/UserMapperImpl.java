package com.example.mapper;

import java.util.List;

import com.example.pojo.User;

import org.mybatis.spring.SqlSessionTemplate;

//Mybatis-plus 通用mapper
public class UserMapperImpl implements UserMapper{

    //在原来我们的所有操作,都是用sqlSession,现在使用sqlSessionTemplate

    private SqlSessionTemplate sqlSession;


    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<User> query() {
        return sqlSession.getMapper(UserMapper.class).query();
    }
    
}
