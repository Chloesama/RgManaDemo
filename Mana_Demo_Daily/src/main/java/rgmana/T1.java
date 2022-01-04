package rgmana;

import org.junit.Test;

import java.nio.charset.StandardCharsets;

/**
 * @ClassName T1
 * @Description TODO
 * @Author RgMana
 * @Date 2022/1/5 0:26
 * @Version 1.0
 **/
public class T1 {
    public static void main(String[] args) {

        Double d1 = new Double(100);
        byte b = d1.byteValue();
        System.out.println(b);
    }

    @Test
    public void test01(){
        String str = "83,99,97,114,108,101,116,33,33,33";
        System.out.println(str.split(",").length);
    }
}