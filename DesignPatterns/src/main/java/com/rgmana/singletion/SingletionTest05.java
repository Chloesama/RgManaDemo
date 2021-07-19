package com.rgmana.singletion;

public class SingletionTest05 {
    public static void main(String[] args) {
        Singletion5 instance = Singletion5.getInstance();
    }
}

//懒汉式(线程安全,同步代码块)
//不用,线程不安全
class Singletion5 {
    private static Singletion5 instance;

    private Singletion5(){

    }

    //提供一个静态的共有方法,当使用到该方法时,才去创建instance
    public static  Singletion5 getInstance(){
        if(instance == null){
            synchronized (Singletion5.class){
                instance = new Singletion5();
            }
        }
        return instance;
    }
}
