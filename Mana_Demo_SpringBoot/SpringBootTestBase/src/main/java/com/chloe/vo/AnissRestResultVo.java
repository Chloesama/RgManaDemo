package com.chloe.vo;

import lombok.Data;

import java.util.Map;

/**
 * @ClassName AnissRestResultVo
 * @Description TODO
 * @Author RgMana
 * @Date 2021/9/23 16:32
 * @Version 1.0
 **/
@Data
public class AnissRestResultVo {
    /**
     * 流水号
     */
    private String serialNum;
    /**
     * 工单号
     */
    private String ticketNum;
    /**
     * 网管专业
     */
    private String specID;
    /**
     * 网管能力名称
     */
    private String reqType;
    /**
     * 网管能力分类
     */
    private String reqTypeLar;
    /**
     * 网管能力小类
     */
    private String reqTypeSma;
    /**
     * 接口调用结果
     */
    private String resultCall;
    /**
     * 失败原因
     */
    private String errDesc;
    /**
     * 网管能力判断结果
     */
    private String resultJudge;
    /**
     * 具体结果信息
     */
    private Map<String,Object> RespData;
}
