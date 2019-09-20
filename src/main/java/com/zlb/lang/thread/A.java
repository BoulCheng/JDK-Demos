package com.zlb.lang.thread;

/**
 * @author Yuanming Tao
 * Created on 2019/5/26
 * Description
 */
public class A {


    public synchronized void print(int i) {
        System.out.println(Thread.currentThread().getName() + i);
    }


    public static void main(String[] args) {


        final A a = new A();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 100; i++) {
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    a.print(i);
                }
            }
        }, "thread-B");

        thread.start();

        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            a.print(i);
        }
    }
}
