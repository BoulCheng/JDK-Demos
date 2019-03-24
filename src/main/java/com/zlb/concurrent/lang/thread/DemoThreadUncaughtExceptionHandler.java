package com.zlb.concurrent.lang.thread;

/**
 * @author Yuanming Tao
 * Created on 2019/3/24
 * Description
 */
public class DemoThreadUncaughtExceptionHandler {


    public static void main(String[] args) {
//        try {
//            throw new NullPointerException();
//        } catch (NullPointerException e) {
////            e.printStackTrace();
//
//            System.err.print("hello");
//            e.printStackTrace(System.err);
//        }


        Thread thread = new Thread(new CustomThreadGroup("CustomThreadGroup2"), new Runnable() {
            @Override
            public void run() {
                throw new NullPointerException();

            }
        }, "CustomThreadGroup2Thread");

//        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
//            @Override
//            public void uncaughtException(Thread t, Throwable e) {
//
//                System.out.println("setUncaughtExceptionHandler success!");
//
//            }
//        });


        /**
         *
         * defaultUncaughtExceptionHandler 是静态变量
         *
         */
//        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
//            @Override
//            public void uncaughtException(Thread t, Throwable e) {
//                System.out.println("setDefaultUncaughtExceptionHandler success!");
//            }
//        });




        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        uncaughtExceptionHandler = thread.getUncaughtExceptionHandler();
        thread.start();


    }
}
