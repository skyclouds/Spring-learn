package com.example.demo2;

public class UserServiceMySQLImpl implements UserService {

    @Override
    public void insert() {
        System.out.println("使用MySQL增加了一个用户");
    }

    @Override
    public void delete() {
        System.out.println("使用MySQL删除了一个用户");
    }

    @Override
    public void update() {
        System.out.println("使用MySQL修改了一个用户");
    }

    @Override
    public void query() {
        System.out.println("使用MySQL查询了一个用户");
    }
}
