package rgmana.test3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ChloeTest3
 * @Description TODO
 * @Author RgMana
 * @Date 2021/7/31 14:03
 * @Version 1.0
 **/
public class ChloeTest3 extends Object{
    public static void main(String[] args) {
        //List<Integer> list = new ArrayList<>();
        //list.add(1);
        //list.add(2);
        //list.add(3);
        //
        //list.forEach((p -> {
        //    System.out.println(p);
        //}));

        Map<String,Integer> map = new HashMap<>();
        map.put("1",1);
        map.put("2",2);
        map.put("3",3);

        map.forEach((k,v) -> {
            System.out.println(k + "," + v);
        });
    }
}
