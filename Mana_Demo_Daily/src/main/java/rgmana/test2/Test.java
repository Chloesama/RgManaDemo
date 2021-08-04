package rgmana.test2;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.formula.functions.T;

/**
 * @ClassName Test
 * @Description TODO
 * @Author RgMana
 * @Date 2021/7/28 20:00
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
        ChloeBean chloeBean = new ChloeBean();
        System.out.println(chloeBean);

        Test test = new Test();
        test.setChloeBean(chloeBean);

        System.out.println(chloeBean);
    }

    public void setChloeBean(ChloeBean chloeBean){
        chloeBean.setA("1");
        chloeBean.setB("2");
        chloeBean.setC("3");
    }
}
