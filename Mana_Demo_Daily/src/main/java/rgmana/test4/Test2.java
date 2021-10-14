package rgmana.test4;

/**
 * @ClassName Test2
 * @Description TODO
 * @Author RgMana
 * @Date 2021/9/16 14:06
 * @Version 1.0
 **/
public class Test2 implements Test1Impl{
    @Override
    public String test(String a) {
        System.out.println("a:" + a);
        return null;
    }

    @Override
    public String test(Object... objects) {
        for(Object object : objects){
            System.out.println("b:" + object);
        }
        return null;
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        test2.test("1",2,new Test3(1,"ab"));
        test2.test("1");
    }
}
