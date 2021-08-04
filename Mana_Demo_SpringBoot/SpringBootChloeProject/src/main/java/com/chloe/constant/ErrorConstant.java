package com.chloe.constant;

/**
 * @ClassName ErrorConstant
 * @Description TODO
 * @Author RgMana
 * @Date 2021/7/22 11:07
 * @Version 1.0
 **/
public interface ErrorConstant {
    /**
     * 成功
     */
    String SUCCESS = "成功";

    /**
     * 注册失败 -- 有重复的用户名
     */
    String ERR_REGISTER_REPEAT_USERNAME = "存在重复的用户名";

    /**
     * 登录失败 -- 密码错误
     */
    String ERR_PASSWORD = "密码错误";

    /**
     * 验证码错误
     */
    String ERR_CAPTCHA = "验证码错误";
}
