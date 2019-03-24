package com.zlb.concurrent.lang.thread;

/**
 * @author Yuanming Tao
 * Created on 2019/3/24
 * Description
 */
public class DemoThreadState {


    private static Object MONOTOR_LOCK = new Object();

    public static void main(String[] args) {
        Thread.State state1;
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (MONOTOR_LOCK) {
                    try {
                        MONOTOR_LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    for (int i = 0; i < 20; i++) {

                        try {
                            Thread.sleep(500L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("A" + i);
                    }
                }
            }
        });
        thread.start();
        try {
            thread.join(1L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("main" + i);
        }

        state1 = thread.getState();
        System.out.println("thread-1:" + state1.name());
        synchronized (MONOTOR_LOCK) {
            MONOTOR_LOCK.notify();
        }

        try {
            thread.join(1L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread.State state;
        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (MONOTOR_LOCK) {
                    Thread.State state2 = Thread.currentThread().getState();
                    System.out.println("3:" + state2.name());
                    for (int i = 0; i < 10; i++) {
                        try {
                            Thread.sleep(500L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("B" + i);
                    }
                }
            }
        });
        state = B.getState();

        System.out.println("1:" + state.name());


        B.start();
        try {
            B.join(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        state = B.getState();
        System.out.println("2:" + state.name());


        state1 = thread.getState();
        System.out.println("thread-2:" + state1.name());

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        state = B.getState();
        System.out.println("4:" + state.name());
    }
}
