package com.chloe.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author hsh
 * @since 2021-09-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ResDzywRestRecode {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id",type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 请求流水号
     * 唯一标识，14位以内的全数字
     */
    @TableField("serial_num")
    private String serialNum;

    /**
     * 校验码
     * md5 (YwLc6bvoFUosR*C + 请求流水号)，YwLc6bvoFUosR*C为固定码
     * 32位大写
     */
    @TableField("check_code")
    private String checkCode;

    /**
     * 接入系统
     * 1：电子运维系统
     * 2：其他系统
     */
    @TableField("system_num")
    private String systemNum;

    /**
     * 工单号
     * 必填，电子运维故障单号
     */
    @TableField("ticket_num")
    private String ticketNum;

    /**
     * 网管专业
     * 4	接入网综合网管
     */
    @TableField("spec_id")
    private String specId;

    /**
     * 发起时间
     */
    @TableField("req_time")
    private LocalDateTime reqTime;

    /**
     * 网管能力名称
     */
    @TableField("req_type")
    private String reqType;

    /**
     * 网管能力分类
     */
    @TableField("req_type_lar")
    private String reqTypeLar;

    /**
     * 网管能力小类
     */
    @TableField("req_type_sma")
    private String reqTypeSma;

    /**
     * 入参
     */
    @TableField("request_data")
    private String requestData;

    /**
     * 接口调用结果
     * 必填（0：成功；1：失败）
     */
    @TableField("result_call")
    private String resultCall;

    /**
     * 失败原因
     * 显示失败原因
     */
    @TableField("err_desc")
    private String errDesc;

    /**
     * 网管能力判断结果
     * 判断业务是否恢复正常
     * 0：正常
     * 1：不正常
     */
    @TableField("result_judge")
    private String resultJudge;

    @TableField("resp_data")
    private String respData;

    @TableField("insert_time")
    private LocalDate insertTime;

    @TableField("reserve1")
    private String reserve1;

    @TableField("reserve2")
    private String reserve2;

    @TableField("reserve3")
    private String reserve3;

    @TableField("reserve4")
    private String reserve4;

    @TableField("reserve5")
    private String reserve5;

    /**
     * 请求信息
     */
    @TableField(exist = false)
    private ReqDataVo reqData;

}
