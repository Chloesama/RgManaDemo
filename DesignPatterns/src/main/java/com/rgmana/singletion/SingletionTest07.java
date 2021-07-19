package com.rgmana.singletion;

public class SingletionTest07 {
    public static void main(String[] args) {
        Singletion7 instance = Singletion7.getInstance();
    }
}

//静态内部类
class Singletion7 {
    private static Singletion7 instance;

    private Singletion7() {

    }

    //静态内部类,该类中有一个静态属性Singletion
    private static class SingletionInstance {
        private static final Singletion7 INSTANCE = new Singletion7();
    }

    public static Singletion7 getInstance(){
        return SingletionInstance.INSTANCE;
    }

}
