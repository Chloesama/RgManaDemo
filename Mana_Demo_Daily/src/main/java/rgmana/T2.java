package rgmana;

/**
 * @ClassName T2
 * @Description TODO
 * @Author RgMana
 * @Date 2021/12/30 22:48
 * @Version 1.0
 **/
public class T2 {
    public static void main(String[] args) {
        String str1 = new String("Chloe");
        String str2 = new String("Chloe");
        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());

        Integer i1 = new Integer(1);
        Integer i2 = new Integer(1);
        System.out.println(i1.hashCode());
        System.out.println(i2.hashCode());
    }
}