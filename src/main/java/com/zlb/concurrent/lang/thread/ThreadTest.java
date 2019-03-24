package com.zlb.concurrent.lang.thread;

/**
 * @author Yuanming Tao
 * Created on 2019/3/24
 * Description
 */
public class ThreadTest {

    private static Object MONITOR_LOCK = new Object();

    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
        int i = 0;
        Thread.dumpStack();

        Thread thread = new Thread();
        boolean b = thread.isAlive();

        threadTest.gg();
//        gg();

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();

        synchronized (MONITOR_LOCK) {
            boolean bb = Thread.holdsLock(MONITOR_LOCK);

            System.out.println(bb);
        }

    }



    private  void gg() {
        System.out.println("gg");
    }
}
