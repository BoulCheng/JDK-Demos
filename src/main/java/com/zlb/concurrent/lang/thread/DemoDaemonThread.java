package com.zlb.concurrent.lang.thread;

/**
 * @author Yuanming Tao
 * Created on 2019/3/21
 * Description
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class DemoDaemonThread
{
    public static void main(String[] args)
    {


        Thread mainThread = new Thread(new Runnable(){
            @Override
            public void run()
            {
                Thread childThread = new Thread(new ClildThread());
                childThread.setDaemon(true);
                childThread.start();
                System.out.println("I'm main thread...");
            }
        });
        mainThread.start();

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    static class ClildThread implements Runnable
    {
        @Override
        public void run()
        {
            while(true)
            {
                System.out.println("I'm child thread..");
                try
                {
                    TimeUnit.MILLISECONDS.sleep(1000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}

