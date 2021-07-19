package com.rgmana.singletion;

public class SingletionTest01 {
    public static void main(String[] args) {
        //测试
        Sinigletion sinigletion = Sinigletion.getInstance();
        Sinigletion sinigletion2 = Sinigletion.getInstance();

        System.out.println(sinigletion == sinigletion2);
        System.out.println(sinigletion.hashCode());
        System.out.println(sinigletion2.hashCode());

    }
}

//饿汉式(静态变量)

class Sinigletion {
    //1.构造器私有化
    private Sinigletion (){

    }

    //2.本类内部创建对象实例
    private final static Sinigletion instance = new Sinigletion();

    //3.提供一个共有的静态方法,返回实例对象
    public static Sinigletion getInstance(){
        return instance;
    }
}