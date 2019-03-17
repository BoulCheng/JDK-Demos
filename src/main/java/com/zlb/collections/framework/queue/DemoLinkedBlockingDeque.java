package com.zlb.collections.framework.queue;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author Yuanming Tao
 * Created on 2019/3/12
 * Description
 */
public class DemoLinkedBlockingDeque {

    public static void main(String[] args) {

        LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque();

        try {
            linkedBlockingDeque.put("1");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
