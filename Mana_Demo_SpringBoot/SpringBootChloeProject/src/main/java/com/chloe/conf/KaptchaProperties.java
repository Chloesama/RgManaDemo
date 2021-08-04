package com.chloe.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Description: 验证码配置类
 * @Author jp
 * @Date 2020/5/15
 **/
@Component
public class KaptchaProperties {

    /**
     <props>
     <prop key="kaptcha.border">no</prop>
     <prop key="kaptcha.border.color">105,179,90</prop>
     <prop key="kaptcha.textproducer.font.color">17,129,213</prop>
     <prop key="kaptcha.image.width">250</prop>
     <prop key="kaptcha.image.height">100</prop>
     <prop key="kaptcha.session.key">code</prop>
     <prop key="kaptcha.textproducer.font.size">80</prop>
     <prop key="kaptcha.textproducer.char.length">4</prop>
     <prop key="kaptcha.textproducer.font.names">宋体,楷体,微软雅黑</prop>
     <prop key="kaptcha.background.clear.from">white</prop>
     </props>
     */
    @Value("${kaptcha.border:no}")
    String border;
    @Value("${kaptcha.border.color:105,179,90}")
    String borderColor;
    @Value("${kaptcha.image.width:250}")
    String imageWidth;
    @Value("${kaptcha.image.height:100}")
    String imageHeight;
    @Value("${kaptcha.session.key:code}")
    String sessionKey;
    @Value("${kaptcha.textproducer.font.color:17,129,213}")
    String fontColor;
    @Value("${kaptcha.textproducer.font.size:80}")
    String fontSize;
    @Value("${kaptcha.textproducer.char.length:4}")
    String charLength;
    @Value("${kaptcha.textproducer.font.names:宋体,楷体,微软雅黑}")
    String fontNames;
    @Value("${kaptcha.background.clear.from:white}")
    String backgroundClearFrom;

    public String getBorder() {
        return border;
    }

    public void setBorder(String border) {
        this.border = border;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    public String getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(String imageWidth) {
        this.imageWidth = imageWidth;
    }

    public String getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(String imageHeight) {
        this.imageHeight = imageHeight;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getFontColor() {
        return fontColor;
    }

    public void setFontColor(String fontColor) {
        this.fontColor = fontColor;
    }

    public String getFontSize() {
        return fontSize;
    }

    public void setFontSize(String fontSize) {
        this.fontSize = fontSize;
    }

    public String getCharLength() {
        return charLength;
    }

    public void setCharLength(String charLength) {
        this.charLength = charLength;
    }

    public String getFontNames() {
        return fontNames;
    }

    public void setFontNames(String fontNames) {
        this.fontNames = fontNames;
    }

    public String getBackgroundClearFrom() {
        return backgroundClearFrom;
    }

    public void setBackgroundClearFrom(String backgroundClearFrom) {
        this.backgroundClearFrom = backgroundClearFrom;
    }
}
