package com.zlb.concurrent.lang.thread;

/**
 * @author Yuanming Tao
 * Created on 2019/3/23
 * Description
 */
public class DemoThreadJoin {

    public static void main(String[] args) {
        //循环五次
        for (int i = 0; i < 5; i++) {

            MyThread thread = new MyThread();
            //启动线程
            thread.start();
            try {
                //调用join()方法
                //The notify() call is internal to the thread system when the thread exits
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("主线程执行完毕");
            System.out.println("~~~~~~~~~~~~~~~");

        }

    }

    public static class MyThread extends Thread {

        @Override
        public void run() {
            System.out.println("子线程执行完毕");
        }
    }
}
