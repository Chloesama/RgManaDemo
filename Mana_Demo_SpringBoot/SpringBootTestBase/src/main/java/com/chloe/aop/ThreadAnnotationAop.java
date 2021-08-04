package com.chloe.aop;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @ClassName ThreadAnnotationApo
 * @Description TODO
 * @Author RgMana
 * @Date 2021/8/3 15:01
 * @Version 1.0
 **/
@Aspect
@Component
@Slf4j
public class ThreadAnnotationAop {

    @Pointcut("@annotation(com.chloe.annotation.ThreadAnnotation)")
    public void threadAnnotation() {
    }

    @Around("threadAnnotation()")
    public void threadAnnotationAround(ProceedingJoinPoint pjp) {
        log.info("切面环绕前");
        new Thread(() -> {
            try {
                pjp.proceed();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }).start();
        log.info("切面环绕后");
    }
}
