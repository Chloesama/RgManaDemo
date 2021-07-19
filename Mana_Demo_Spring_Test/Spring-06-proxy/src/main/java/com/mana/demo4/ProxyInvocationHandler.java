package com.mana.demo4;

import com.mana.demo3.Rent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//自动生成代理类!
public class ProxyInvocationHandler implements InvocationHandler {

    //被代理的接口
    private Object obj;

    public void setObj(Object obj) {
        this.obj = obj;
    }

    //生成得到代理类
    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
    }

    //处理代理示例,并返回结果
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //动态代理的本质,就是使用反射机制实现!
        this.log(method.getName());
        Object result = method.invoke(obj, args);
        return result;
    }

    public void log(String msg){
        System.out.println("执行了" + msg + "方法!");
    }

}
