package rgmana.test5;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName AnissRestVo
 * @Description TODO
 * @Author RgMana
 * @Date 2021/9/23 15:59
 * @Version 1.0
 **/
@Data
public class AnissRestVo implements Serializable {

    private static final long serialVersionUID= 8239617416787276350L;
    /**
     * 请求流水号
     * 唯一标识，14位以内的全数字
     */
    private String serialNum;

    /**
     * 校验码
     * md5 (YwLc6bvoFUosR*C + 请求流水号)，YwLc6bvoFUosR*C为固定码
     * 32位大写
     */
    private String checkCode;

    /**
     * 接入系统
     * 1：电子运维系统
     * 2：其他系统
     */
    private String systemNum;

    /**
     * 工单号
     * 必填，电子运维故障单号
     */
    private String ticketNum;

    /**
     * 网管专业
     * 4	接入网综合网管
     */
    private String specID;

    /**
     * 发起时间
     */
    private String reqTime;

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
     * 请求信息
     */
    private ReqDataVo reqData;
}
