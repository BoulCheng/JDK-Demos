package com.zlb.concurrent.executor.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Yuanming Tao
 * Created on 2019/4/3
 * Description
 */
public class DemoScheduledThreadPoolExecutor {

    public static void main(String[] args) {

        /**
         * 会通过阻塞队列的take至少保留一个线程活跃
         * boolean timed = allowCoreThreadTimeOut || wc > corePoolSize
         * Runnable r = timed ? workQueue.poll(keepAliveTime, TimeUnit.NANOSECONDS) : workQueue.take()
         */
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("task1-success!");
            }
        };

        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("task2-success!");
                return null;
            }
        };
        scheduledExecutorService.schedule(runnable, 5L, TimeUnit.SECONDS);
        scheduledExecutorService.schedule(callable, 5L, TimeUnit.SECONDS);
//        Executors.newSingleThreadScheduledExecutor();
//        Executors.newSingleThreadExecutor()
        System.out.println("end!");

        start();
    }

    private static void start() {

        /**
         *    public ScheduledThreadPoolExecutor(int corePoolSize) {
         *         super(corePoolSize, Integer.MAX_VALUE, 0, NANOSECONDS,
         *               new DelayedWorkQueue());
         *     }
         *     ScheduledExecutorService的workQueue是无界队列，所以永远都只会有核心线程数个线程在调度任务。不会有超过核心线程数个线程存在于线程池中。
         *     ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1) 可一明确观察到只有一个线程在调度任务
         */


        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
                System.out.println(simpleDateFormat.format(new Date()) + ":task3-success!");

                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
                System.out.println(simpleDateFormat.format(new Date()) + ":task4-success!");

                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };


        scheduledExecutorService.scheduleAtFixedRate(runnable, 1L, 2L, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleWithFixedDelay(runnable2, 1L, 2L, TimeUnit.SECONDS);
    }

}
