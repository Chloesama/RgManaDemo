package mana.util.json;

import com.alibaba.fastjson.JSON;
import mana.util.Exception.ExceptionSoutUtil;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonUtil {

    private static JsonJackBuilder jackBuilder;
    private static JsonGsonBuilder gsonBuilder;

    /**
     * 讲jason字符串转换为对应的实体类。
     * 如果JSON字符串为Null或"null"字符串,返回Null.
     * 如果JSON字符串为"[]",返回空集合.
     * 如需读取集合如List/Map,且不是List<String>这种简单类型时使用如下语句:
     * List<MyBean> beanList = binder.getMapper().readValue(listString, new TypeReference<List<MyBean>>() {});
     */
    public static <T> T getObjectByJackson(String jsonString, Class<T> clazz) {
        try {
            if (jackBuilder == null) {
                jackBuilder = JsonJackBuilder.buildNonNull();
            }
            return jackBuilder.fromJson(jsonString, clazz);
        } catch (Exception e) {
            ExceptionSoutUtil.getTrace(e);
        }
        return null;
    }

    /**
     * 转换为json
     */
    public static String toJacksonByObject(Object obj) {
        try {
            if (jackBuilder == null) {
                jackBuilder = JsonJackBuilder.buildNonNull();
            }
            return jackBuilder.toJson(obj);
        } catch (Exception e) {
            ExceptionSoutUtil.getTrace(e);
        }
        return null;
    }

    //Gson
    public static String toGsonByObject(Object object) {
        if (gsonBuilder == null) {
            gsonBuilder = JsonGsonBuilder.buildGson();
        }
        return gsonBuilder.toJson(object);
    }

    public static <T> T getObjectByGson(String jsonString, Class<T> clazz) {
        if (gsonBuilder == null) {
            gsonBuilder = JsonGsonBuilder.buildGson();
        }
        return gsonBuilder.fromJson(jsonString, clazz);
    }

    //fastJson
    public static String toFastJsonByObject(Object object) {
        return JSON.toJSONString(object);
    }

    public static <T> T getObjectByFactJson(String jsonString, Class<T> clazz) {

        return JSON.parseObject(jsonString, clazz);
    }

    /**
     * 去掉JSON非法字符
     */
    public String rmJsonIllegalChar(String value) {//去掉json非法字符
        if (StringUtils.contains(value, "\"")) {
            value = StringUtils.replace(value, "\"", "");
        }
        if (StringUtils.contains(value, "\\")) {
            value = StringUtils.replace(value, "\\", "");//去掉非法字符
        }
        return value;
    }


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Chloe");
        list.add("RgMana");
        list.add("Reimu");

//        String listStr = JsonUtil.toJacksonByObject(list);
//        String listStr = JsonUtil.toGsonByObject(list);
        String listStr = JsonUtil.toFastJsonByObject(list);

        System.out.println(listStr);

//        List<String> l1 = JsonUtil.getObjectByJackson(listStr, List.class);
//        List<String> l1 = JsonUtil.getObjectByGson(listStr, List.class);
        List<String> l1 = JsonUtil.getObjectByFactJson(listStr, List.class);

        System.out.println(l1);

        Map<String, String> map = new HashMap<>();
        map.put("Chloe", "1");
        map.put("RgMana", "2");
        map.put("Reimu", "3");

//        String mapStr = JsonUtil.toJacksonByObject(map);
//        String mapStr = JsonUtil.toGsonByObject(map);
        String mapStr = JsonUtil.toFastJsonByObject(map);

        System.out.println(mapStr);
//        Map<String, String> map2 = JsonUtil.getObjectByJackson(mapStr, Map.class);
//        Map<String, String> map2 = JsonUtil.getObjectByGson(mapStr, Map.class);
        Map<String, String> map2 = JsonUtil.getObjectByFactJson(mapStr, Map.class);
        System.out.println(map2);
    }

}
