package rgmana.test5;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName ReqDataVo
 * @Description TODO
 * @Author RgMana
 * @Date 2021/9/23 16:33
 * @Version 1.0
 **/
@Data
public class ReqDataVo implements Serializable {

    private static final long serialVersionUID= 8229617416787276350L;

    /**
     * 地市
     * 填写地市缩写，如GZ，FS
     */
    private String sCity;
    /**
     * 细分专业
     * 针对接入网专业，细分专业为：
     * 1.FTTX   2.IP
     */
    private String sSpecialtyID;
    /**
     * 网管告警流水号
     * 可支持多条，用英文逗号隔开
     */
    private String sSAlarmID;
    /**
     * 网元IP地址
     */
    private String sNeIP;
    /**
     * 网元类型
     */
    private String sNeType;
    /**
     * 网元名称
     */
    private String sNeName;
    /**
     * 板卡类型
     */
    private String sBoardType;
    /**
     * 板卡名称
     */
    private String sBoardName;
    /**
     * 端口类型
     */
    private String sPortType;
    /**
     * 端口名称
     */
    private String sPortName;
    /**
     * 业务类型/专线类型
     * 例如：1.云专线，2.云高速
     */
    private String sCircType;
    /**
     * 业务编号/专线号
     */
    private String sCircNum;
    /**
     * 告警标题
     */
    private String sAlarmTitle;
}
