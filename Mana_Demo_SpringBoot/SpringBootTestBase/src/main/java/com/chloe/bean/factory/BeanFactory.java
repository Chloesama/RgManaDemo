package com.chloe.bean.factory;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @ClassName BeanFactory
 * @Description TODO
 * @Author RgMana
 * @Date 2022/1/6 15:43
 * @Version 1.0
 **/
@Component
public class BeanFactory implements ApplicationContextAware {
    private static ApplicationContext applicationContext = null;

    public BeanFactory() {
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.setApplicationContextStatic(applicationContext);
    }

    private void setApplicationContextStatic(ApplicationContext applicationContext) {
        BeanFactory.applicationContext = applicationContext;
    }

    public void destroy() throws Exception {
        clear();
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static <T> T getBean(String name) {
        return (T) applicationContext.getBean(name);
    }

    public static <T> T getBean(Class<T> requiredType) {
        return applicationContext.getBean(requiredType);
    }

    public static boolean containsBean(String name) {
        return applicationContext.containsBean(name);
    }

    public static void clear() {
        applicationContext = null;
    }


}
