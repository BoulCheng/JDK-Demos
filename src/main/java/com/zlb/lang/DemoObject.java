package com.zlb.lang;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author Yuanming Tao
 * Created on 2019/3/23
 * Description  Object wait notify sample
 * @see com.zlb.concurrent.locks.DemoCondition2 异曲同工
 */
public class DemoObject {

    private final static Object MONITOR_LOCK = new Object();


    public static void main(String[] args) {
        try {
            //必须先获取到锁
            MONITOR_LOCK.notify();
        } catch (Exception e) {
            /**
             * java.lang.IllegalMonitorStateException
             * 抛出的异常都是和{@link AbstractQueuedSynchronizer.ConditionObject#signal()}  } 一样的
             */
            e.printStackTrace();
        }

        try {
            MONITOR_LOCK.wait();
        } catch (Exception e) {
            /**
             * //java.lang.IllegalMonitorStateException
             * 抛出的异常都是和{@link AbstractQueuedSynchronizer.ConditionObject#await()} 一样的
             */
            e.printStackTrace();
        }


        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (MONITOR_LOCK) {
                    for (int i = 0; i < 20; i++) {
                        System.out.println("子线程 before wait" + i);
                        try {
                            Thread.sleep(500L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        //Condition 是 await
                        //condition.await();
                        //主线程  condition.signal(); 且 unlock后才会继续执行

                        //主线程  MONITOR_LOCK.notify(); 且 unlock MONITOR_LOCK后才会继续执行
                        MONITOR_LOCK.wait();
                        for (int i = 0; i < 20; i++) {
                            System.out.println("子线程 after wait" + i);
                            try {
                                Thread.sleep(500L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        System.out.println("main");


        synchronized (MONITOR_LOCK) {
            for (int i = 0; i < 20; i++) {
                System.out.println("main lock" + i);
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //condition.signal();
            MONITOR_LOCK.notify();
            for (int i = 0; i < 20; i++) {
//                System.out.println("main signal" + i);
                System.out.println("main notify" + i);
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }



    }


}
