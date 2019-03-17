package com.zlb.collections.framework.queue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author Yuanming Tao
 * Created on 2019/3/11
 * Description
 */
public class DemoArrayBlockingQueue {

    public static void main(String[] args) {

        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(2, true);

        try {
            arrayBlockingQueue.put("1");
            String s = arrayBlockingQueue.take();

            arrayBlockingQueue.put("2");
            s = arrayBlockingQueue.take();


            arrayBlockingQueue.put("3");
            s = arrayBlockingQueue.take();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
