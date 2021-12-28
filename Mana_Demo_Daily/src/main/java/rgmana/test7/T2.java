package rgmana.test7;

import org.junit.Test;

/**
 * @ClassName T2
 * @Description TODO
 * @Author RgMana
 * @Date 2021/12/28 14:47
 * @Version 1.0
 **/
public class T2 {
    @Test
    public void test01() {
        String str = "test:# ,test1:#,test2:#";

        str = str.replaceFirst("#","a");

        System.out.println(str);
        str = str.replaceFirst("#","b");
        System.out.println(str);
        str = str.replaceFirst("#","c");
        System.out.println(str);
    }
}
