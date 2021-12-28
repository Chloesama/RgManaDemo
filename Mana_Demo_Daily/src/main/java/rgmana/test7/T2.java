package rgmana.test7;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName T2
 * @Description TODO
 * @Author RgMana
 * @Date 2021/12/28 14:47
 * @Version 1.0
 **/
public class T2 {
    @Test
    public void test01() {
        String str = "test:# ,test1:#,test2:#";

        str = str.replaceFirst("#","a");

        System.out.println(str);
        str = str.replaceFirst("#","b");
        System.out.println(str);
        str = str.replaceFirst("#","c");
        System.out.println(str);
    }

    @Test
    public void test02(){
        Set<String> set = new HashSet<>();
        set.add("1");
        set.add("3");
        set.add("2");
        set.add("1");
        for (String str : set) {
            System.out.println(str);
        }

        System.out.println("----");
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("3");
        list.add("2");
        list.add("1");
        for (String s : list) {
            System.out.println(s);
        }
    }
}
