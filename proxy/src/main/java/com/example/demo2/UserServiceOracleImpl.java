package com.example.demo2;

public class UserServiceOracleImpl implements UserService {

    @Override
    public void insert() {
        System.out.println("使用Oracle增加了一个用户");
    }

    @Override
    public void delete() {
        System.out.println("使用Oracle删除了一个用户");
    }

    @Override
    public void update() {
        System.out.println("使用Oracle修改了一个用户");
    }

    @Override
    public void query() {
        System.out.println("使用Oracle查询了一个用户");
    }
}
