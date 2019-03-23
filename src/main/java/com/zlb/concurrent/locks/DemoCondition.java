package com.zlb.concurrent.locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Yuanming Tao
 * Created on 2019/3/23
 * Description
 */
public class DemoCondition {

    public static void main(String[] args) {

        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();

        try {
            /**
             * 为获得锁的情况下等待会抛异常
             */
            condition.signal();
//            condition.await();
        } catch (Exception e) {
            //java.lang.IllegalMonitorStateException
            e.printStackTrace();
        }

    }

}
