package com.zlb.concurrent.locks;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Yuanming Tao
 * Created on 2019/3/17
 * Description
 */
public class DemoReentrantLock {

    /**
     * 默认Nofair
     */
    static final ReentrantLock reentrantLock = new ReentrantLock(true);
    static final ReentrantLock reentrantLock2 = new ReentrantLock(true);

    public static void main(String[] args) {

        //未获得锁的情况释放锁
        //reentrantLock.unlock();

//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                reentrantLock.lock();
//            }
//        });
//        thread.start();
//        try {
//            Thread.sleep(1000L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        reentrantLock.lock();
//        try {
//            int i = 0;
//        } finally {
//            reentrantLock.unlock();
//        }
        reentrant();
    }


    private static void reentrant() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                reentrantLock2.lock();
                try {
                    Thread.sleep(60000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock2.unlock();
                }
            }
        });
        thread.start();

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        reentrantLock2.lock();
        try {
            int i = 0;
        } finally {
            reentrantLock2.unlock();
        }
    }
}
