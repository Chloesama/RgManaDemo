import mana.service.UserService;
import mana.service.UserServiceImpl;

public class ManaTest {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.getUser();
    }
}
