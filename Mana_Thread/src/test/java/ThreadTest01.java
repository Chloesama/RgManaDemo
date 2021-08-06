import lombok.SneakyThrows;
import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @ClassName ThreadTest01
 * @Description TODO
 * @Author RgMana
 * @Date 2021/8/4 17:27
 * @Version 1.0
 **/
public class ThreadTest01 {
    public static void main(String[] args) {
        method1(10);
    }

    private static void method1(int x){
        int y = x + 1;
        Object o = method2();
        System.out.println(o);
    }

    private static Object method2(){
        Object n = new Object();
        return n;
    }

    @Test
    public void test1(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

    @Test
    public void test2(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Chloe");
    }

    @SneakyThrows
    @Test
    public void test3(){
        Thread thread = new Thread(() -> {
            System.out.println("Chloe-park");
            LockSupport.park();
            System.out.println("Chloe-unPark");
            System.out.println("打断的状态--" + Thread.currentThread().isInterrupted());

            //这里的park就不会生效了,因为下面的interrupt导致isInterrupted = true
            LockSupport.park();
            System.out.println("Chloe-unPark2");

            /**
             * 修改isInterrupted 为false
             */
            Thread.interrupted();
            System.out.println("Chloe状态-" + Thread.currentThread().isInterrupted());
        });
        thread.start();

        Thread.sleep(1000);
        thread.interrupt();
    }

    @Test
    public void test4(){
        T t = new T();
        new Thread(() -> t.a()).start();
        new Thread(() -> t.b()).start();
    }

    class T{
        public synchronized void a(){
            //System.out.println("在a啦
            System.out.println("a");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public synchronized void b(){
            System.out.println("b");
        }
    }

}
