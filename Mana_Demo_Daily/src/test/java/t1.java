import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName t1
 * @Description TODO
 * @Author RgMana
 * @Date 2021/10/21 11:19
 * @Version 1.0
 **/
public class t1 {
    @Test
    public void t1() {
        List<Map<String,String>> list = new ArrayList<>();
        Map<String,String> map1 = new HashMap<>();
        Map<String,String> map2 = new HashMap<>();

        map1.put("1","1");
        map2.put("2","2");

        list.add(map1);
        list.add(map2);

        List<Map<String, String>> collect = list.stream().filter(l -> l.get("3") != null).collect(Collectors.toList());

        System.out.println(collect);

    }
}
