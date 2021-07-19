package mana.util.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import mana.util.Exception.ExceptionSoutUtil;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;

public class JsonGsonBuilder {

    private Gson gson;

    private JsonGsonBuilder() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public static JsonGsonBuilder buildGson() {
        return new JsonGsonBuilder();
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

        return gson.fromJson(jsonString,clazz);
    }

    /**
     * 如果对象为Null,返回"null".
     * 如果集合为空集合,返回"[]".
     */
    public String toJson(Object object) {
        return gson.toJson(object);
    }

}
