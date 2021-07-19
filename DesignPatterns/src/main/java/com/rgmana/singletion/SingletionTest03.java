package com.rgmana.singletion;

public class SingletionTest03 {
    public static void main(String[] args) {
        Singletion3 instance = Singletion3.getInstance();
    }
}

//懒汉式(线程不安全)
class Singletion3 {
    private static Singletion3 instance;

    private Singletion3(){

    }

    //提供一个静态的共有方法,当使用到该方法时,才去创建instance
    public static Singletion3 getInstance(){
        if(instance == null){
            instance = new Singletion3();
        }
        return instance;
    }
}
