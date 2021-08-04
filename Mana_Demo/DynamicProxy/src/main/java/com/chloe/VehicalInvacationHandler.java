package com.chloe;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName VehicalInvacationHandler
 * @Description TODO
 * @Author RgMana
 * @Date 2021/7/26 14:50
 * @Version 1.0
 **/
public class VehicalInvacationHandler implements InvocationHandler {
    private IVehical vehical;

    public VehicalInvacationHandler(IVehical vehical) {
        this.vehical = vehical;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        System.out.println("---------------------before-----");
        Object invoke = method.invoke(vehical,args);
        System.out.println("---------------------after-----");
        return invoke;
    }
}
