package Monitor;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.currentThread;

/**
 * @Author:sgyt
 * @Description:
 * @Date:2019/1/4 10:48
 */
public class ClassMonitor {
    public static synchronized void method1(){
        System.out.println(currentThread().getName()+"enter to method1");
        try {
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void method2(){
        System.out.println(currentThread().getName()+"enter to method2");
        try {
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
//    这里造成了实例之间的锁，明明锁住的方法，但是方法间形成了互锁

    public static void main(String[] args) {
        ThisMonitor thisMonitor = new ThisMonitor();
        new Thread(thisMonitor::method1,"T1").start();
        new Thread(thisMonitor::method2,"T2").start();
    }
}
