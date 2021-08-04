package com.chloe;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @ClassName MyBeanPostProcessor
 * @Description TODO
 * @Author RgMana
 * @Date 2021/7/27 10:21
 * @Version 1.0
 **/
public class MyBeanPostProcessor implements BeanPostProcessor {
    public MyBeanPostProcessor(){
        System.out.println("MyBeanPostProcessor 实现类构造函数...");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if("chloeBean".equals(beanName)){
            System.out.println("BeanPostProcessor 实现类postProcessBeforeInitialization方法被调用中...");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if("chloeBean".equals(beanName)){
            System.out.println("BeanPostProcessor 实现类postProcessAfterInitialization方法被调用中...");
        }
        return bean;
    }
}
