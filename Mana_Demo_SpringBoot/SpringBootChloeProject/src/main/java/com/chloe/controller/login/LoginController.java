package com.chloe.controller.login;

import cn.hutool.core.codec.Base64;
import com.chloe.constant.Constant;
import com.chloe.constant.ErrorConstant;
import com.chloe.constant.RedisConstant;
import com.chloe.entity.CommonResult;
import com.chloe.pojo.user.User;
import com.chloe.redis.RedisUtil;
import com.chloe.srv.user.UserSrv;
import com.chloe.util.DataUtil;
import com.google.code.kaptcha.Producer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Author RgMana
 * @Date 2021/7/21 11:25
 * @Version 1.0
 **/
@Slf4j
@RestController
@RequestMapping("login")
public class LoginController {

    @Resource
    Producer captchaProducer;

    @Resource
    RedisUtil redisUtil;

    @Resource
    UserSrv userSrv;

    @GetMapping("getCaptcha")
    public CommonResult<Map<String, Object>> getCaptcha() {
        Map<String, Object> returnMap = new HashMap<>(2);
        String captcha = captchaProducer.createText();
        BufferedImage bi = captchaProducer.createImage(captcha);
        String captchaCode = UUID.randomUUID().toString().replaceAll("-", "");
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            ImageIO.write(bi, "jpg", out);
            returnMap.put("captcha", Base64.encode(out.toByteArray()));
            out.flush();

            redisUtil.set(RedisConstant.captcha + captchaCode, captcha, Constant.captchaTimeOut);
            returnMap.put("captchaCode", captchaCode);
        } catch (Exception e) {
            log.error("生成验证码输出流时出现异常:[{}]", e.getMessage());
        }

        return CommonResult.succeed(returnMap);
    }

    @GetMapping("registerUser")
    public CommonResult<String> registerUser(User user) {
        String result = userSrv.registerUser(user);
        CommonResult<String> commonResult;
        if (result.equals(ErrorConstant.SUCCESS)) {
            commonResult = CommonResult.succeed();
        } else {
            commonResult = CommonResult.failed(result);
        }
        return commonResult;
    }

    @GetMapping("authLogin")
    public CommonResult<Map<String, Object>> authLogin(@RequestParam(required = false) String userName,
                                                       @RequestParam(required = false) String passWord,
                                                       @RequestParam(required = false) String captcha,
                                                       @RequestParam(required = false) String captchaCode) {
        CommonResult<Map<String, Object>> commonResult;
        Map<String, Object> resultMap = new HashMap<>(2);

        String result = userSrv.authLogin(userName, passWord, captcha, captchaCode, resultMap);
        if (!result.equals(ErrorConstant.SUCCESS)) {
            commonResult = CommonResult.failed(result);
        } else {
            commonResult = CommonResult.succeed(resultMap);
        }
        return commonResult;
    }

    @GetMapping("getUser")
    public CommonResult<User> getUser(@RequestParam(required = false) String token){
        Object o = redisUtil.get(RedisConstant.captcha + token);
        User user = null;
        if(o != null){
            user = (User) o;
        }
        return CommonResult.succeed(user);
    }
}
