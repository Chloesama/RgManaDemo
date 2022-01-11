package rgmana;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @ClassName NetsharDateUtil
 * @Description TODO
 * @Author RgMana
 * @Date 2021/9/27 15:15
 * @Version 1.0
 **/
public class NetsharkDateUtil {

    public static String formatter1 = "yyyy-MM-dd HH:mm:ss";
    public static String formatter2 = "yyyy-MM-dd";

    private static DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static Date localDateTimeToDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static LocalDateTime strToLocalDateTime(String str) {
        return LocalDateTime.parse(str, df);
    }

    public static String LocalDateTimeToStr(LocalDateTime localDateTime) {
        return df.format(localDateTime);
    }

    public static String LocalDateTimeToStr(LocalDateTime localDateTime, String formatter) {
        df = DateTimeFormatter.ofPattern(formatter);
        return df.format(localDateTime);
    }
}
