package com.chloe.srv.user;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.chloe.constant.ErrorConstant;
import com.chloe.constant.RedisConstant;
import com.chloe.pojo.user.User;
import com.chloe.redis.RedisUtil;
import com.chloe.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Flux;

import javax.annotation.Resource;
import java.util.Map;
import java.util.UUID;

/**
 * @ClassName UserSrv
 * @Description TODO
 * @Author RgMana
 * @Date 2021/7/21 22:27
 * @Version 1.0
 **/
@Slf4j
@Service
public class UserSrv {
    @Resource
    UserService userService;

    @Resource
    RedisUtil redisUtil;

    String result = ErrorConstant.SUCCESS;

    public String registerUser(User user) {

        if (this.getUserByUserName(user.getUserName()) == null) {
            userService.save(user);
        } else {
            result = ErrorConstant.ERR_REGISTER_REPEAT_USERNAME;
        }
        return result;
    }

    public User getUserById(Long id) {
        return userService.getById(id);
    }

    public User getUserByUserName(String userName) {
        QueryWrapper<User> queryWrapper = Wrappers.query();
        queryWrapper.lambda().eq(User::getUserName, userName);
        return userService.getOne(queryWrapper);
    }

    public String authLogin(String userName, String passWord, String captcha, String captchaCode, Map<String, Object> resultMap) {
        //先判断验证码
        try {
            Object o = redisUtil.get(RedisConstant.captcha + captchaCode);
            if (o != null) {
                if (captcha.equals(o.toString())) {
                    User user = this.getUserByUserName(userName);
                    if (!passWord.equals(user.getPassWord())) {
                        result = ErrorConstant.ERR_PASSWORD;
                    } else {
                        resultMap.put("user", user);
                        String token = UUID.randomUUID().toString().replace("-", "");
                        try {
                            redisUtil.hset(token, JSON.toJSONString(user), RedisConstant.tokenTimeout);
                            resultMap.put("token", token);
                        } catch (Exception e) {
                            result = ErrorConstant.ERR_CAPTCHA;
                            log.error("设置token失败!");
                        }
                    }
                } else {
                    result = ErrorConstant.ERR_CAPTCHA;
                }
            } else {
                result = ErrorConstant.ERR_CAPTCHA;
            }
        } catch (Exception e) {
            result = ErrorConstant.ERR_CAPTCHA;
            log.error("获取验证码失败!");
        }

        //处理完之后,无论什么结果,都要删掉验证码
        try {
            redisUtil.del(RedisConstant.captcha + captchaCode);
        } catch (Exception e) {
            result = ErrorConstant.ERR_CAPTCHA;
            log.error("删除验证码失败!");
        }
        return result;
    }
}
