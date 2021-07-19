import mana.pojo.Hello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ManaTest {
    public static void main(String[] args) {
        //获取Spring的上下文对象
        ApplicationContext context = new ClassPathXmlApplicationContext( "beans.xml");
        Hello hello = (Hello) context.getBean("hello");
        System.out.println(hello.toString());

        hello.setStr("123");
        Hello hello2 = (Hello) context.getBean("hello");
        System.out.println(hello2.toString());
    }
}
