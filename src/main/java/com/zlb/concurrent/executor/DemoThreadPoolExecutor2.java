package com.zlb.concurrent.executor;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Yuanming Tao
 * Created on 2019/4/3
 * Description
 */
public class DemoThreadPoolExecutor2 {

    public static void main(String[] args) {


        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2, 1000L, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(100));


        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                System.out.println("runnable success!");

            }
        };

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {

                System.out.println("runnable1 success!");

            }
        };

        /**
         * 统一个Runnable可以重复被提交执行，因为每次提交都会有新的FutureTask实例，而同一个FutureTask实例不会被run()方法多次执行
         */
        threadPoolExecutor.submit(runnable);
        threadPoolExecutor.submit(runnable);
        threadPoolExecutor.submit(runnable1);

    }
}
