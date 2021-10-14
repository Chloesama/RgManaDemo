package mana.util.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import mana.util.Exception.ExceptionSoutUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class JsonJackBuilder {

    private ObjectMapper mapper;

    private JsonJackBuilder(JsonInclude.Include include) {
        mapper = new ObjectMapper();

        //序列化的时候序列对象的所有属性
        mapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);

        //反序列化的时候如果多了其他属性,不抛出异常
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        //如果是空对象的时候,不抛异常
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        //属性为null的转换
        mapper.setSerializationInclusion(include);

        //取消时间的转化格式,默认是时间戳,可以取消,同时需要设置要表现的时间格式
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * 输出全部属性到Json字符串
     */
    public static JsonJackBuilder buildNormal() {
        return new JsonJackBuilder(JsonInclude.Include.ALWAYS);
    }

    /**
     * 【只】输出【非空】属性到Json字符串
     */
    public static JsonJackBuilder buildNonNull() {
        return new JsonJackBuilder(JsonInclude.Include.NON_NULL);
    }

    /**
     * 【只】输出【初始值被改变】的属性到Json字符串
     */
    public static JsonJackBuilder buildNonDefault() {
        return new JsonJackBuilder(JsonInclude.Include.NON_DEFAULT);
    }

    /**
     * 如果JSON字符串为Null或"null"字符串,返回Null.
     * 如果JSON字符串为"[]",返回空集合.
     * 如需读取集合如List/Map,且不是List<String>这种简单类型时使用如下语句:
     * List<MyBean> beanList = binder.getMapper().readValue(listString, new TypeReference<List<MyBean>>() {});
     */
    public <T> T fromJson(String jsonString, Class<T> clazz) {
        if (StringUtils.isEmpty(jsonString)) {
            return null;
        }

        try {
            //对放斜杠进行特殊处理，避免jason出错
            return mapper.readValue(jsonString, clazz);
        } catch (IOException e) {
            ExceptionSoutUtil.getTraString(e);
            return null;
        }
    }

    /**
     * 如果对象为Null,返回"null".
     * 如果集合为空集合,返回"[]".
     */
    public String toJson(Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (IOException e) {
            ExceptionSoutUtil.getTraString(e);
            return null;
        }
    }

}
