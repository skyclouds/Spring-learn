package com.example.demo2;

public class UserServiceOracleImpl implements UserService {

    public void insert() {
        System.out.println("使用Oracle增加了一个用户");
    }

    public void delete() {
        System.out.println("使用Oracle删除了一个用户");
    }

    public void update() {
        System.out.println("使用Oracle修改了一个用户");
    }

    public void query() {
        System.out.println("使用Oracle查询了一个用户");
    }
}
