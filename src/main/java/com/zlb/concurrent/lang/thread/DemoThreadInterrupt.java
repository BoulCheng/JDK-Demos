package com.zlb.concurrent.lang.thread;

/**
 * @author Yuanming Tao
 * Created on 2019/3/26
 * Description
 */
public class DemoThreadInterrupt {


    public static void main(String[] args) {


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 100; i++) {
                    System.out.println("1:" + i);
                    try {
                        Thread.sleep(100000L);
                    } catch (InterruptedException e) {
                        boolean b = Thread.interrupted();
                        System.out.println(Thread.currentThread().getName() + b);
                        e.printStackTrace();
                    }
                }
            }
        }, "thread-1");
        thread.start();
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            boolean b = Thread.interrupted();
            System.out.println(Thread.currentThread().getName() + b);
            e.printStackTrace();
        }

        //中断触发后thread-1catch中断异常后进入下一循环再进入sleep
        thread.interrupt();
    }

}
