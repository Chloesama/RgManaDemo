package com.rgmana.singletion;

public class SingletionTest08 {

    public static void main(String[] args) {
        Singletion8 instance = Singletion8.INSTANCE;
    }

    //枚举
    enum Singletion8 {
        INSTANCE;
    }
}
