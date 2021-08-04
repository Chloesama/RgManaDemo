package com.chloe.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName ThreadAnnotation
 * @Description TODO
 * @Author RgMana
 * @Date 2021/8/3 15:00
 * @Version 1.0
 **/
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ThreadAnnotation {
}
