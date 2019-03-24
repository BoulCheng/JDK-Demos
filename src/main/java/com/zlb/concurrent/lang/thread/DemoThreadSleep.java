package com.zlb.concurrent.lang.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Yuanming Tao
 * Created on 2019/3/21
 * Description sleep不会释放锁
 */
public class DemoThreadSleep {

    private static final Object lock = new Object();

    private static ReentrantLock reentrantLock = new ReentrantLock();
//
//    private static Thread thread1 = new Thread(new Runnable() {
//        @Override
//        public void run() {
//            synchronized (lock) {
//                for (int i = 0; i < 10; i++) {
//                    try {
//                        Thread.sleep(500L);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println("A" + i);
//                }
//            }
//        }
//    });


    private static Thread thread1 = new Thread(new Runnable() {
        @Override
        public void run() {
            reentrantLock.lock();
            try {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(500L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("A" + i);
                }
            } finally {
                reentrantLock.unlock();

            }
        }
    });

//    private static Thread thread2 = new Thread(new Runnable() {
//        @Override
//        public void run() {
//            synchronized (lock) {
//                for (int i = 0; i < 10; i++) {
//                    System.out.println("B" + i);
//                }
//            }
//        }
//    });

    private static Thread thread2 = new Thread(new Runnable() {
        @Override
        public void run() {
            reentrantLock.lock();
            try {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(500L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("B" + i);
                }
            } finally {
                reentrantLock.unlock();

            }
        }
    });
    public static void main(String[] args) {

        thread1.start();

        thread2.start();
    }





}
