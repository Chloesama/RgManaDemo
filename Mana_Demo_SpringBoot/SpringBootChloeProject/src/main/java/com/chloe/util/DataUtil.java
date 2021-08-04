package com.chloe.util;

import com.chloe.entity.CommonResult;
import org.apache.poi.ss.formula.functions.T;

import java.util.Map;

/**
 * @ClassName DataUtil
 * @Description TODO
 * @Author RgMana
 * @Date 2021/7/22 14:26
 * @Version 1.0
 **/
public class DataUtil<T> {

    public static <T> T getData(Map<String, Object> data, String str){
        return data.get(str) == null ? null : (T)data.get(str);
    }
}
