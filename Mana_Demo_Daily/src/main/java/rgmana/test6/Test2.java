package rgmana.test6;

import org.junit.Test;
import org.w3c.dom.Node;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName Test2
 * @Description TODO
 * @Author RgMana
 * @Date 2021/12/10 14:15
 * @Version 1.0
 **/
public class Test2 {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>(2);
        Map<String,String> map2 = new HashMap<>();

        map.put("a","a");
        map.put("b","b");
        map.put("b","c");
        map.put("d","d");

        System.out.println(1 << 30);
    }

    @Test
    public void t1(){
        int MAXIMUM_CAPACITY = 1 << 30;
        int cap = 5;
        int n = cap - 1;
        System.out.println("Scarlet1:" + n);
        n |= n >>> 1;
        System.out.println("Scarlet2:" + n);
        n |= n >>> 2;
        System.out.println("Scarlet3:" + n);
        n |= n >>> 4;
        System.out.println("Scarlet4:" + n);
        n |= n >>> 8;
        System.out.println("Scarlet5:" + n);
        n |= n >>> 16;
        System.out.println("Scarlet6:" + n);



        n =  (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;

        System.out.println("Scarlet7:" + n);
    }

    @Test
    public void t2(){
        Node node;
        Node node1;
        //node1 = node;
    }

    public class Node{

    }

    @Test
    public void t3(){
        Map<String,String> map = new HashMap<>();
        map.put("b","b");
        map.put("c","c");
        map.put("a","a");

        for (String s : map.keySet()) {
            System.out.println(s + "," + s.hashCode());
        }
    }
}
