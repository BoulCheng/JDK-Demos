package lang;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yuanming Tao
 * Created on 2019/8/22
 * Description
 */
public class DemoObjectWaitNotify {

    private static List<Integer> list = new ArrayList();


    public static void main(String[] args) {

        Object lock = new Object();

        new Thread(new RunnableA(lock)).start();

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new RunnableB(lock)).start();

    }


    static class RunnableA implements Runnable {


        private final Object lock;

        public RunnableA(final Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {

            synchronized (lock) {

                if (list.size() != 5) {
                    System.out.println("wait...");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("wait->notify");
                }

            }

        }
    }


    static class RunnableB implements Runnable {


        private final Object lock;

        public RunnableB(final Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {

            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    list.add(i);
                    System.out.println("add:" + i);
                    if (list.size() == 5) {
                        // 执行完lock.notify();并没有释放锁，所以调用lock.wait();的线程重新获得锁并不会成功！
                        lock.notify();
                        System.out.println("notify called!");
                    }
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }

        }
    }
}

