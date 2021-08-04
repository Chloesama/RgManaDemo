package rgmana.test3;

import lombok.Data;
import mana.util.json.JsonUtil;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName RgManaTest1
 * @Description TODO
 * @Author RgMana
 * @Date 2021/7/31 21:54
 * @Version 1.0
 **/
public class RgManaTest1 {
    public static void main(String[] args) {
        new Thread(() -> System.out.println(Thread.currentThread().getName() + "-1")).start();
    }

    @Test
    public void test1(){
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(99);
        list.add(1);
        list.add(10);
        list.add(8);

        list.stream().sorted(Comparator.comparingInt(o -> o)).forEach(l ->{
            System.out.println(l);
        });
    }

    @Test
    public void test2(){
        User user = new User();
        System.out.println(Optional.ofNullable(user).map(u -> u.getUsername()).map(username -> username = "测试").get());
    }

    @Test
    public void test3(){

        char a = 0x39;

        System.out.println(a);

        //char[8] t = [0x30,0x0e,0x39,0x07];

        //char a[8] ;

    }

    @Data
    class User{
        String username = "ABC";
        String password;
    }
}
