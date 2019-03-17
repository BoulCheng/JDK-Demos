package com.zlb.concurrent.synchronized2;

/**
 * @author Yuanming Tao
 * Created on 2019/1/4
 * Description
 */
public class MultiLockSync {

    private static Object lock = new Object();
    private static final Object DEFAULT_LOCK = new Object();
    private static final Object LOCKA = new Object();
    private static final Object LOCKB = new Object();
    private static final Object LOCKC = new Object();
    private static final Object LOCKD = new Object();
    private static final Object LOCKE = new Object();


    public static void multiLock(Integer lockIndex) {
        lock = getSpecifiedLock(lockIndex);
        synchronized (lock) {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }

    }


    public static Object getSpecifiedLock(Integer lockIndex) {
        if (lockIndex == null) {
            return DEFAULT_LOCK;
        } else if (lockIndex == 1) {
            return LOCKA;
        } else if (lockIndex == 2) {
            return LOCKB;
        } else if (lockIndex == 3) {
            return LOCKC;
        } else if (lockIndex == 4) {
            return LOCKD;
        } else if (lockIndex == 5) {
            return LOCKE;
        } else {
            return DEFAULT_LOCK;
        }
    }
}
