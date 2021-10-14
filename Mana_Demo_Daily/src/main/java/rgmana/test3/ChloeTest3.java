package rgmana.test3;

import java.text.NumberFormat;

/**
 * @ClassName ChloeTest3
 * @Description TODO
 * @Author RgMana
 * @Date 2021/7/31 14:03
 * @Version 1.0
 **/
public class ChloeTest3 extends Object {
    public static void main(String[] args) {
        for(int i = 0;i<100;i++){
            NumberFormat nf = NumberFormat.getNumberInstance();
            nf.setMaximumFractionDigits(2);
            nf.setGroupingUsed(false);
            double d1 = 95;
            double d = Math.random();
            d = d % 0.30;
            double a = (Math.random() * 100) % 2;
            int b = (int)a;
            double d2 = 0;
            if(b == 0){
                d2 = d1 + Double.valueOf(nf.format(d));
            }else{
                d2 = d1 - Double.valueOf(nf.format(d));
            }
            System.out.println(d2);
        }
    }
}
