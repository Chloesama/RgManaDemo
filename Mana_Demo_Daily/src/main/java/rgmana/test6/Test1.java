package rgmana.test6;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @ClassName Test1
 * @Description TODO
 * @Author RgMana
 * @Date 2021/9/27 15:25
 * @Version 1.0
 **/
public class Test1 {

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        System.out.println(LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli());
        System.out.println(System.currentTimeMillis());
    }
}
