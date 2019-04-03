package com.zlb.concurrent.executor;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Yuanming Tao
 * Created on 2019/3/25
 * Description
 */
public class DemoCustomThreadPool {

    private static final int CORE_POOL_SIZE = 40;
    private static final int MAX_POOL_SIZE = 200;
    private static final Long KEEP_ALIVE_TIME = 1000L;
    private static final int WORK_QUEUE_CAPACITY = 10000;

    private static ThreadPoolExecutor threadPoolExecutor = getThreadPoolExecutor();

    public static void execute(Runnable runnable) {
        threadPoolExecutor.execute(runnable);
    }

    private static ThreadPoolExecutor getThreadPoolExecutor() {
        return new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>(WORK_QUEUE_CAPACITY), new SettlementThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());
    }

    private static class SettlementThreadFactory implements ThreadFactory {
        private static AtomicLong id = new AtomicLong(0);
        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, "Settlement-thread-pool-" + id.addAndGet(1));
        }
    }
}

