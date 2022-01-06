package rgmana;

import lombok.ToString;

/**
 * @ClassName ChloeTest
 * @Description TODO
 * @Author RgMana
 * @Date 2022/1/6 16:16
 * @Version 1.0
 **/
@ToString
public class ChloeTest {
    String str1;
    String str2;
    Integer i1;

    public ChloeTest() {

    }

    public ChloeTest(String str1, String str2) {
        this.str1 = str1;
        this.str2 = str2;
    }
    //
    public ChloeTest(String str1, String str2, Integer i1) {
        this.str1 = str1;
        this.str2 = str2;
        this.i1 = i1;
    }
}
