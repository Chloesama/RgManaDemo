package rgmana.test5;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Test1
 * @Description TODO
 * @Author RgMana
 * @Date 2021/9/22 15:11
 * @Version 1.0
 **/
public class Test1 {

    public static void main(String[] args) {
        AnissRestVo anissRestVo = new AnissRestVo();
        anissRestVo.setSerialNum("123123");
        ReqDataVo reqDataVo = new ReqDataVo();
        reqDataVo.setSAlarmTitle("123");
        anissRestVo.setReqData(reqDataVo);
        System.out.println(JSON.toJSONString(anissRestVo));
    }
}
