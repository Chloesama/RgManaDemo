package com.chloe;


import java.lang.reflect.Proxy;

/**
 * @ClassName Test
 * @Description TODO
 * @Author RgMana
 * @Date 2021/7/26 14:52
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
        IVehical car = new Car();
        IVehical vehical = (IVehical) Proxy.newProxyInstance(car.getClass().getClassLoader(),Car.class.getInterfaces(),new VehicalInvacationHandler(car));
        vehical.run();
    }
}
