package rgmana;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName T1
 * @Description TODO
 * @Author RgMana
 * @Date 2021/12/30 13:41
 * @Version 1.0
 **/
public class T1 {
    @Test
    public void test01(){
        String ipAddress = "13.12.1.1";

        String str = "12.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\b";

        System.out.println(str);

        Pattern pattern = Pattern.compile(str);

        Matcher matcher = pattern.matcher(ipAddress);

        System.out.println(matcher.matches());
    }
}
