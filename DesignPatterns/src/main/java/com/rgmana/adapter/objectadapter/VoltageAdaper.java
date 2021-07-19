package com.rgmana.adapter.objectadapter;


//对象适配器
public class VoltageAdaper extends Voltage220V implements Voltage5V {

    private Voltage220V voltage220V;

    public VoltageAdaper(Voltage220V voltage220V) {
        this.voltage220V = voltage220V;
    }

    @Override
    public int output5V() {
        int dst = 0;
        if(voltage220V != null){
            int src = voltage220V.output220V();
            System.out.println("使用对象适配器,进行适配");
            dst = src / 44;
        }
        return dst;
    }
}
