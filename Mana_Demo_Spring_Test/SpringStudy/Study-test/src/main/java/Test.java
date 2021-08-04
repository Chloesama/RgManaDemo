import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName Test
 * @Description TODO
 * @Author RgMana
 * @Date 2021/7/26 15:00
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans/xml");
    }
}
