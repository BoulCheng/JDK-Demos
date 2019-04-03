package com.zlb.concurrent.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Yuanming Tao
 * Created on 2019/4/1
 * Description
 */
public class DemoExecutors {

    public static void main(String[] args) {
        /**
         * reuse previously constructed threads when they are available
         * SynchronousQueue
         */
        ExecutorService es = Executors.newCachedThreadPool();

        /**
         * 无keepAliveTime
         * 最大最小线程数相同
         * 无界队列
         */
        es = Executors.newFixedThreadPool(1);

        /**
         * Unlike the otherwise equivalent {@code newFixedThreadPool(1)} the returned executor is guaranteed not to be reconfigurable to use additional threads.
         * 线程池不可重新配置通过 DelegatedExecutorService 实现
         * DelegatedExecutorService is A wrapper class that exposes only the ExecutorService methods of an ExecutorService implementation.(只暴露ExecutorService接口方法)
         */
        Executors.newSingleThreadExecutor();

    }
}
