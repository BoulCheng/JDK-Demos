package com.zlb.lang.threadLocal;

/**
 * @author Yuanming Tao
 * Created on 2019/4/24
 * Description
 */
public class DemoThreadLocal {

    public static void main(String[] args) {
        final ThreadLocal threadLocal = new ThreadLocal() {
            @Override
            protected Object initialValue() {
                return "1";
            }
        };

        Object o;
        o = threadLocal.get();
        System.out.println(Thread.currentThread().getName() + ":" + o.toString());

        o = threadLocal.get();
        System.out.println(Thread.currentThread().getName() + ":" + o.toString());

        o = threadLocal.get();
        System.out.println(Thread.currentThread().getName() + ":" + o.toString());


        threadLocal.set("2");
        o = threadLocal.get();
        System.out.println(Thread.currentThread().getName() + ":" + o.toString());

        new Thread(()->{
            threadLocal.set("9");
            int i = 0;
            while (i <= 20) {
                i++;
                Object o2 = threadLocal.get();
                System.out.println(Thread.currentThread().getName() + ":" + o2.toString());
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "thread-child").start();

        int i = 0;
        while (i <= 20) {
            i++;
            o = threadLocal.get();
            System.out.println(Thread.currentThread().getName() + ":" + o.toString());
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

//        test();

    }

    public static void test() {

        ThreadLocal threadLocal = new ThreadLocal() {
            @Override
            protected Object initialValue() {
                return "5";
            }
        };

        Object o;
        o = threadLocal.get();
        System.out.println(o.toString());

        o = threadLocal.get();
        System.out.println(o.toString());

        o = threadLocal.get();
        System.out.println(o.toString());


        threadLocal.set("6");
        o = threadLocal.get();
        System.out.println(o.toString());

    }


    public static void testReHash() {

        final ThreadLocal threadLocal = new ThreadLocal() {
            @Override
            protected Object initialValue() {
                return "1";
            }
        };


        new Thread(()->{
            threadLocal.set("9");
        }, "thread-child").start();
    }
}
