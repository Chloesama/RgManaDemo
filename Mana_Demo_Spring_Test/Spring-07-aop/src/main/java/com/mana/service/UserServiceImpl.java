package com.mana.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService{

    ChloeBean chloeBean;

    @Autowired
    public UserServiceImpl(ChloeBean abc){
        this.chloeBean = abc;
        System.out.println(chloeBean);
    }

    @Override
    public void add() {
        System.out.println("增加了一个用户");
    }

    @Override
    public void del() {
        System.out.println("删除了一个用户");
    }

    @Override
    public void update() {
        System.out.println("修改了一个用户");
    }

    @Override
    public void query() {
        System.out.println("查询了一个用户");
    }
}
