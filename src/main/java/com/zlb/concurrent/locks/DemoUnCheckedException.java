package com.zlb.concurrent.locks;


/**
 * @author Yuanming Tao
 * Created on 2019/6/12
 * Description
 */
public class DemoUnCheckedException {


    public static void main(String[] args) {

        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("child");
                int i = 1 / 0;

                System.out.println("child2");

            }
        };

        Thread thread = new Thread(r);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        gg();

        System.out.println("end");

    }

    public static void gg() {
    }


}
