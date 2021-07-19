package com.mana.demo4;

import com.mana.demo2.UserService;
import com.mana.demo2.UserServiceImpl;

public class Client {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();

        ProxyInvocationHandler pih = new ProxyInvocationHandler();
        pih.setObj(userService);
        UserService userServiceProxy = (UserService) pih.getProxy();
        userServiceProxy.add();
        userServiceProxy.query();
    }
}
