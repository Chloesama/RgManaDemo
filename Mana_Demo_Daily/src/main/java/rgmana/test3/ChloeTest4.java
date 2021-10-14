package rgmana.test3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @ClassName ChloeTest4
 * @Description TODO
 * @Author RgMana
 * @Date 2021/9/10 14:18
 * @Version 1.0
 **/
public class ChloeTest4 {
    public static void main(String[] args) {
        String d1 = "2021-09-13 10:12:11";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date d2 = formatter.parse(d1);
            LocalDateTime  d3 = date2LocalDate(d2);
            System.out.println(d3);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static LocalDateTime date2LocalDate(Date date) {
        if(null == date) {
            return null;
        }
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}
