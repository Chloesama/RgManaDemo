package com.chloe.main;

import com.alibaba.fastjson.JSON;
import com.chloe.vo.ResDzywRestRecode;

import java.time.LocalDateTime;

/**
 * @ClassName TestMain
 * @Description TODO
 * @Author RgMana
 * @Date 2021/9/24 10:54
 * @Version 1.0
 **/
public class TestMain {

    public static void main(String[] args) {
        String a = "{\"specID\":\"123\",\"reqData\":{\"sAlarmTitle\":\"123\"},\"serialNum\":\"123\",\"ticketNum\":\"123\",\"reqType\":\"123\",\"systemNum\":\"123\",\"reqTime\":\"2021-09-24T10:58:49.685\",\"checkCode\":\"2ec0d1cbd2fc9a57fb85af31d6bbbcec\"}";

        ResDzywRestRecode resDzywRestRecode = JSON.parseObject(a, ResDzywRestRecode.class);
        System.out.println(resDzywRestRecode.getReqTime());

        //ResDzywRestRecode resDzywRestRecode = new ResDzywRestRecode();
        //resDzywRestRecode.setReqTime(LocalDateTime.now());
        //
        //System.out.println(JSON.toJSONString(resDzywRestRecode));
    }
}
