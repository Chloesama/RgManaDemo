package rgmana.test;

/**
 * @ClassName TestMain
 * @Description TODO
 * @Author RgMana
 * @Date 2021/7/24 22:15
 * @Version 1.0
 **/
public class TestMain {

    public static void main(String[] args) {
        TestInterface testInterface = new TestRealization();
        testInterface.test();

        TestInterface testInterface2 = new TestRealization2();
        testInterface2.test();
    }
}
