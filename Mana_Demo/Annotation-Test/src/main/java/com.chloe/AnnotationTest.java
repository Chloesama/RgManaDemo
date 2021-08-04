package com.chloe;

import java.lang.annotation.*;

/**
 * @ClassName AnnotationTest
 * @Description TODO
 * @Author RgMana
 * @Date 2021/7/28 14:53
 * @Version 1.0
 **/
public class AnnotationTest {
    /**
     * 注解可以显示赋值,如果没有默认值,我们就必须注解赋值
     */
    @ChloeAnnotation(name = "Chloe")
    public void test(){

    }
}

/**
 * @ClassName AnnotationTest
 * @Description TODO
 * @Author RgMana
 * @Date 2021/7/28 14:53
 * @Version 1.0
 **/
//表示我们的注解可以用在哪些地方
@Target(value = {ElementType.METHOD,ElementType.TYPE})
//表示我们的注解在什么地方还有效
@Retention(value = RetentionPolicy.RUNTIME)
//表示是否将我们的注解生成在JavaDoc中
@Documented
//子类可以继承父类的注解
@Inherited
@interface ChloeAnnotation{
    //注解的参数: 参数类型 + 参数名 ()
    String name() default "";
}