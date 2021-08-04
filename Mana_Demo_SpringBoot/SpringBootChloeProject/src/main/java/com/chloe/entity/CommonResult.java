package com.chloe.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName CommonResult
 * @Description TODO
 * @Author RgMana
 * @Date 2021/7/21 11:27
 * @Version 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> implements Serializable {
    private T data;
    private Integer resultCode;
    private String resultDesc;

    public static <T> CommonResult<T> succeed(){
        return succeedWith(null, 200, "成功");
    }

    public static <T> CommonResult<T> succeed(String msg) {
        return succeedWith(null, 200, msg);
    }

    public static <T> CommonResult<T> succeed(T model, String msg) {
        return succeedWith(model, 200, msg);
    }

    public static <T> CommonResult<T> succeed(T model) {
        return succeedWith(model, 200, "成功");
    }

    public static <T> CommonResult<T> succeedWith(T data, Integer resultCode, String resultDesc) {
        return new CommonResult<>(data, resultCode, resultDesc);
    }

    public static <T> CommonResult<T> failed(String msg) {
        return failedWith(null, 500, msg);
    }

    public static <T> CommonResult<T> failed(T model, String msg) {
        return failedWith(model, 500, msg);
    }

    public static <T> CommonResult<T> failedWith(T data, Integer resultCode, String resultDesc) {
        return new CommonResult<>(data, resultCode, resultDesc);
    }

}