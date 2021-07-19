package com.rgmana.singletion;

public class SingletionTest06 {
    public static void main(String[] args) {
        Singletion6 instance = Singletion6.getInstance();
    }
}

//双重检查
class Singletion6 {
    private static volatile Singletion6 instance;

    private Singletion6() {

    }

    //提供一个静态的共有方法,当使用到该方法时,才去创建instance
    public static Singletion6 getInstance() {
        if (instance == null) {
            synchronized (Singletion6.class) {
                if (instance == null) {
                    instance = new Singletion6();
                }
            }
        }
        return instance;
    }
}
