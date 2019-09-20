package com.zlb.concurrent.locks;

/**
 * @author Yuanming Tao
 * Created on 2019/6/12
 * Description
 */
public class DeadLock {


    static class A {

        synchronized void lockA(B b) {
            System.out.println("A#lockA");

            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("go B#lockB2");
            b.lockB2();
            System.out.println("done B#lockB2");
        }

        synchronized void lockA2() {
            System.out.println("A#lockA2");
        }

    }


    static class B {

        synchronized void lockB(A a) {
            System.out.println("B#lockB");

            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("go A#lockA2");
            a.lockA2();
            System.out.println("done A#lockA2");
        }

        synchronized void lockB2() {
            System.out.println("B#lockB2");
        }

    }


    public static void main(String[] args) {

        A a = new A();
        B b = new B();

        Runnable r = new Runnable() {
            @Override
            public void run() {
                a.lockA(b);
            }
        };

        new Thread(r).start();
        b.lockB(a);

    }
}

