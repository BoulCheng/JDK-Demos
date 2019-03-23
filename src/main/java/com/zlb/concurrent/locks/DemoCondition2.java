package com.zlb.concurrent.locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Yuanming Tao
 * Created on 2019/3/23
 * Description  condition await signal sample
 */
public class DemoCondition2 {

    public static void main(String[] args) {

        final ReentrantLock reentrantLock = new ReentrantLock();

        final Condition condition = reentrantLock.newCondition();

        new Thread(new Runnable() {
            @Override
            public void run() {
                reentrantLock.lock();
                try {
                    for (int i = 0; i < 20; i++) {
                        System.out.println("子线程 before await" + i);
                        try {
                            Thread.sleep(500L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        condition.await();
                        //主线程  condition.signal(); 且 unlock后才会继续执行
                        for (int i = 0; i < 20; i++) {
                            System.out.println("子线程 after await" + i);
                            try {
                                Thread.sleep(500L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } finally {
                    reentrantLock.unlock();
                }
            }
        }).start();

        System.out.println("main");

        reentrantLock.lock();
        try {
            for (int i = 0; i < 20; i++) {
                System.out.println("main lock" + i);
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            condition.signal();
            for (int i = 0; i < 20; i++) {
                System.out.println("main signal" + i);
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            reentrantLock.unlock();
        }


    }
}
