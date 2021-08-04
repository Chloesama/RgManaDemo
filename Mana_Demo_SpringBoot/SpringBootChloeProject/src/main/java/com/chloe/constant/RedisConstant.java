package com.chloe.constant;

/**
 * @ClassName RedisConstant
 * @Description TODO
 * @Author RgMana
 * @Date 2021/7/21 15:27
 * @Version 1.0
 **/
public interface RedisConstant {
    /**
     * 验证码
     */
    String captcha = "captcha:";

    /**
     * 登录超时时间
     */
    int tokenTimeout = 30 * 60;
}
