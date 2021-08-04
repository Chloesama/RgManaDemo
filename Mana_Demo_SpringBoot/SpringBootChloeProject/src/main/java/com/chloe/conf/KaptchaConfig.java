package com.chloe.conf;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @Description: 验证码配置类
 * @Author jp
 * @Date 2020/5/15
 **/
@Configuration
public class KaptchaConfig {
    @Autowired
    KaptchaProperties kaptchaProperties;

    @Bean
    public DefaultKaptcha captchaProducer(){
        // 创建DefaultKaptcha对象
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        Properties properties = new Properties();
        // 图片边框
        properties.setProperty("kaptcha.border", kaptchaProperties.getBorder());
        // 边框颜色
        properties.setProperty("kaptcha.border.color", kaptchaProperties.getBorderColor());
        // 字体颜色
        properties.setProperty("kaptcha.textproducer.font.color", kaptchaProperties.getFontColor());
        // 图片宽
        properties.setProperty("kaptcha.image.width", kaptchaProperties.getImageWidth());
        // 图片高
        properties.setProperty("kaptcha.image.height", kaptchaProperties.getImageHeight());
        // 字体大小
        properties.setProperty("kaptcha.textproducer.font.size", kaptchaProperties.getFontSize());
        // session key
        properties.setProperty("kaptcha.session.key", kaptchaProperties.getSessionKey());
        // 验证码长度
        properties.setProperty("kaptcha.textproducer.char.length", kaptchaProperties.getCharLength());
        // 字体
        properties.setProperty("kaptcha.textproducer.font.names",kaptchaProperties.getFontNames());
//        <prop key="kaptcha.background.clear.from">white</prop>
        defaultKaptcha.setConfig(new Config(properties));
        properties.setProperty("kaptcha.background.clear.from",kaptchaProperties.getBackgroundClearFrom());
        return defaultKaptcha;
    }

}
