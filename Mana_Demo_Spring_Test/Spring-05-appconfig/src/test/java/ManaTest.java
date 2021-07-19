import com.mana.config.ManaConfig;
import com.mana.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ManaTest {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ManaConfig.class);
        User user = context.getBean("getUser", User.class);
        System.out.println(user.getName());
    }
}
