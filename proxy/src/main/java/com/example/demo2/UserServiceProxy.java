package com.example.demo2;

public class UserServiceProxy implements UserService{
    private UserServiceMySQLImpl userService;

    public void setUserService(UserServiceMySQLImpl userService) {
        this.userService = userService;
    }

    @Override
    public void insert() {
        log("insert");
        userService.insert();
    }

    @Override
    public void delete() {
        log("delete");
        userService.delete();
    }

    @Override
    public void update() {
        log("update");
        userService.update();
    }

    @Override
    public void query() {
        log("query");
        userService.query();
    }

    //日志方法
    public void log(String msg){
        System.out.println("[Debug]"+"使用了"+msg+"方法");
    }
}
