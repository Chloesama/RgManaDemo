package com.rgmana.adapter.classadapter;


//类适配器
public class VoltageAdaper extends Voltage220V implements Voltage5V{

    @Override
    public int output5V() {
        //先获取到220V电压
        int src = output220V();
        int dstV = src / 44;
        return dstV;
    }
}
