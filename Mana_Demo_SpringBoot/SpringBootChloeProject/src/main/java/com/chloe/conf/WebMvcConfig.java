package com.chloe.conf;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * webMvc配置
 * @author liushangkun
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.removeIf(converter -> converter instanceof AbstractJackson2HttpMessageConverter);

        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.DisableCircularReferenceDetect,
                // 输出值为null的字段
                SerializerFeature.WriteMapNullValue,
//                SerializerFeature.WriteNullNumberAsZero,
                // 字符类型字段如果为null,输出为”“,而非null
                SerializerFeature.WriteNullStringAsEmpty,
                // List字段如果为null,输出为[],而非null
                SerializerFeature.WriteNullListAsEmpty,
//                SerializerFeature.WriteNullBooleanAsFalse,
                SerializerFeature.WriteNonStringKeyAsString,
                // Enum输出name()或者original
                SerializerFeature.WriteEnumUsingToString,
                // 适配IE6的输出，占用内存会更多, 自动适配部分浏览器（火狐，Chrome内核）下，long精度失精度的问题
                SerializerFeature.BrowserCompatible
        );

        fastJsonConfig.setSerializeFilters((ValueFilter) (object, name, value) -> {
            // 将BigDecimal和BigInteger统一转换为字符串
            if(value instanceof BigDecimal || value instanceof BigInteger) {
                return value.toString();
            }
            if (value instanceof LocalDateTime) {
                return ((LocalDateTime) value).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            }
            if (value instanceof LocalDate) {
                return ((LocalDate) value).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            }
            if (value instanceof LocalTime) {
                return ((LocalTime) value).format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            }
            return value;
        });
        fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");

        // 处理中文乱码问题
        List<MediaType> fastMediaTypes = new ArrayList<>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON);
        fastConverter.setSupportedMediaTypes(fastMediaTypes);
        fastConverter.setFastJsonConfig(fastJsonConfig);

        //处理字符串, 避免直接返回字符串的时候被添加了引号
        StringHttpMessageConverter smc = new StringHttpMessageConverter(StandardCharsets.UTF_8);
        converters.add(smc);
        converters.add(0, fastConverter);
    }

}