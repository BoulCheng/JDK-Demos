package com.zlb.concurrent.lang.thread;

/**
 * @author Yuanming Tao
 * Created on 2019/3/24
 * Description
 */
public class CustomThreadGroup extends ThreadGroup {

    public CustomThreadGroup(String name) {
        super(name);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {

        System.out.println("CustomThreadGroup success!");
    }
}
