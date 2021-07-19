package com.mana.demo3;

public class Client {
    public static void main(String[] args) {
        //真实角色
        Host host = new Host();

        //代理角色
        ProxyInvocationHandler pih = new ProxyInvocationHandler();
        //通过调用程序角色来处理我们要调用的接口对象!
        pih.setRent(host);

        Rent rentProxy = (Rent) pih.getProxy();

        rentProxy.rent();

    }
}
