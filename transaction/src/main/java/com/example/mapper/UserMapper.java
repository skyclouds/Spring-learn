package com.example.mapper;

import java.util.List;

import com.example.pojo.User;

public interface UserMapper {

    public List<User> test1();

    public List<User> query();

    public int insert(User user);

    public int deleteById(int id);
}
