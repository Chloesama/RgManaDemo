package rgmana;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/**
 * @ClassName T1
 * @Description TODO
 * @Author RgMana
 * @Date 2022/1/5 0:26
 * @Version 1.0
 **/
public class T1 {
    public static void main(String[] args) {

        Double d1 = new Double(100);
        byte b = d1.byteValue();
        System.out.println(b);
    }

    @Test
    public void test01() throws InstantiationException, IllegalAccessException, InvocationTargetException {
        chloeTest("Chloe");
    }

    public static void chloeTest(String a, Object... params) throws InstantiationException, IllegalAccessException, InvocationTargetException {
        Object[] o = params;

        Class<ChloeTest> chloeTestClass = ChloeTest.class;

        Constructor<?>[] constructors = chloeTestClass.getConstructors();

        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor.getParameterCount() + "," + o.length);
            if (constructor.getParameterCount() == o.length) {
                ChloeTest chloeTest = (ChloeTest) constructor.newInstance(params);

                System.out.println("Scarlet:" + chloeTest);
            }
        }

        System.out.println(o.length);
    }
}