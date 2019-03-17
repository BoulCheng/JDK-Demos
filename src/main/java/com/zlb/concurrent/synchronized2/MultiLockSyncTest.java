package com.zlb.concurrent.synchronized2;

/**
 * @author Yuanming Tao
 * Created on 2019/1/4
 * Description
 */
public class MultiLockSyncTest {


    /**
     * synchronized使用不同的隐式监视器锁，获得不同的隐式监视器锁的线程互相执行不影响
     * @param args
     */
    public static void main(String[] args) {
        Thread threadA = new Thread(new MultiLockSyncRunnable(1), "A");
        Thread threadB = new Thread(new MultiLockSyncRunnable(2), "B");
        Thread threadC = new Thread(new MultiLockSyncRunnable(3), "C");
        Thread threadD = new Thread(new MultiLockSyncRunnable(4), "D");
        Thread threadE = new Thread(new MultiLockSyncRunnable(5), "E");
        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
        threadE.start();
    }
}
