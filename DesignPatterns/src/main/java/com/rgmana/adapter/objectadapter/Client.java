package com.rgmana.adapter.objectadapter;

//对象适配器模式
public class Client {

    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.charging(new VoltageAdaper(new Voltage220V()));
    }
}
