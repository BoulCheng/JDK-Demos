package com.zlb.concurrent.locks;

import java.util.concurrent.locks.LockSupport;

/**
 * @author Yuanming Tao
 * Created on 2019/5/10
 * Description
 */
public class Demo {


    public static void main(String[] args) {

//        test();
//        test2();
//        test3();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(0);
                LockSupport.park();
                System.out.println(111);
//                for (; ; ) {
//                    LockSupport.unpark(Thread.currentThread());
//                    System.out.println(111);
//                }
            }
        });

        thread.start();
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();

    }

    static void test() {
        System.out.println("1");
        LockSupport.park();
        System.out.println("2");
    }

    static void test2() {
        LockSupport.unpark(Thread.currentThread());
        System.out.println("1");
        LockSupport.park();
        System.out.println("2");
        LockSupport.park();
        System.out.println("3");
    }

    static void test3() {
        LockSupport.unpark(Thread.currentThread());
        LockSupport.unpark(Thread.currentThread());
        LockSupport.unpark(Thread.currentThread());
        System.out.println("1");
        LockSupport.park();
        System.out.println("2");
        LockSupport.park();
        System.out.println("3");
    }
}
