package com.rgmana.singletion;

public class SingletionTest02 {
    public static void main(String[] args) {
        //测试
        Sinigletion2 sinigletion = Sinigletion2.getInstance();
        Sinigletion2 sinigletion2 = Sinigletion2.getInstance();


    }
}

//饿汉式(静态代码块)

class Sinigletion2 {
    //1.构造器私有化
    private Sinigletion2() {

    }

    //2.本类内部创建对象实例
    private static Sinigletion2 instance;

    //在静态代码块中.创建单例对象
    static {
        instance = new Sinigletion2();
    }

    //3.提供一个共有的静态方法,返回实例对象
    public static Sinigletion2 getInstance() {
        return instance;
    }
}