package com.rgmana.singletion;

public class SingletionTest04 {
    public static void main(String[] args) {
        Singletion4 instance = Singletion4.getInstance();
    }
}

//懒汉式(线程安全,同步方法)
//不用,执行效率太低
class Singletion4 {
    private static Singletion4 instance;

    private Singletion4(){

    }

    //提供一个静态的共有方法,当使用到该方法时,才去创建instance
    //加入同步代码,解决线程不安全问题
    public static synchronized Singletion4 getInstance(){
        if(instance == null){
            instance = new Singletion4();
        }
        return instance;
    }
}
