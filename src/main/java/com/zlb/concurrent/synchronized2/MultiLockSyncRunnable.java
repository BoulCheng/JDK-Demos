package com.zlb.concurrent.synchronized2;

/**
 * @author Yuanming Tao
 * Created on 2019/1/4
 * Description
 */
public class MultiLockSyncRunnable implements Runnable {

    private Integer lockIndex;

    public MultiLockSyncRunnable(Integer lockIndex) {
        this.lockIndex = lockIndex;
    }

    @Override
    public void run() {
        MultiLockSync.multiLock(lockIndex);
    }
}
