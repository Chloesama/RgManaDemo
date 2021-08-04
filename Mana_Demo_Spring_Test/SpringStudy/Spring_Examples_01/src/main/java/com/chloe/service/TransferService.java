package com.chloe.service;

/**
 * @ClassName TransferService
 * @Description TODO
 * @Author RgMana
 * @Date 2021/7/22 20:29
 * @Version 1.0
 **/
public interface TransferService {
    void transfer(String fromCardNo,String toCardNo,int money) throws Exception;
}
