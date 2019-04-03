package com.zlb.concurrent.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Yuanming Tao
 * Created on 2019/3/28
 * Description
 */
public class DemoThreadPoolExecutor {

    private static ThreadPoolExecutor settlementAssetThreadPoolExecutor = new ThreadPoolExecutor(2, 16, 2, TimeUnit.MINUTES, new LinkedBlockingDeque<Runnable>(100), new SettlementAssetThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());

    public static void main(String[] args) {
        List<Callable<String>> callableList = new ArrayList<>();
        callableList.add(new Callable() {
            @Override
            public String call() throws Exception {
                System.out.println(111);
                return "1";
            }
        });
        callableList.add(new Callable() {
            @Override
            public String call() throws Exception {
                System.out.println(222);
                return "222";
            }
        });
        callableList.add(new Callable() {
            @Override
            public String call() throws Exception {
                System.out.println(333);
                return "333";
            }
        });
        callableList.add(new Callable() {
            @Override
            public String call() throws Exception {
                System.out.println(444);
                return "444";
            }
        });

        String re;
        try {
            re = settlementAssetThreadPoolExecutor.invokeAny(callableList);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        List<Future<String>> ret2;
        try {
            ret2 = settlementAssetThreadPoolExecutor.invokeAll(callableList);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        Future<String> future = settlementAssetThreadPoolExecutor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "call";
            }
        });
        String ret = null;
        try {
            ret = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        Future future1 = settlementAssetThreadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {
            }
        });

        Future<String> future3 = settlementAssetThreadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {

            }
        }, "runnable");

        try {
            ret = future3.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println(ret);
    }

    private static class SettlementAssetThreadFactory implements ThreadFactory {
        private static AtomicLong id = new AtomicLong(0);
        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, "settlementAssetThread-" + id.addAndGet(1));
        }
    }
}
