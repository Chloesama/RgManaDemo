package com.mana.demo2;

public class UserServiceProxy implements UserService{

    UserServiceImpl userService;

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public void add() {
        this.log("add");
        userService.add();
    }

    @Override
    public void del() {
        this.log("del");
        userService.del();
    }

    @Override
    public void update() {
        this.log("update");
        userService.update();
    }

    @Override
    public void query() {
        this.log("query");
        userService.query();
    }

    public void log(String msg){
        System.out.println("使用了" + msg + "方法");
    }

}
