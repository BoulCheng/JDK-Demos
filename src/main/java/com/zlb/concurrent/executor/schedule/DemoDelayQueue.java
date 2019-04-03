package com.zlb.concurrent.executor.schedule;

import com.alibaba.fastjson.JSON;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import static java.util.concurrent.TimeUnit.*;

/**
 * @author Yuanming Tao
 * Created on 2019/4/2
 * Description
 */
public class DemoDelayQueue {

    private static final AtomicLong sequencer = new AtomicLong();
    private static final AtomicLong id = new AtomicLong();

    public static void main(String[] args) {

        //Converts the given time duration in the given unit to this unit.
        long l = TimeUnit.MILLISECONDS.convert(1000000, NANOSECONDS);
        l = TimeUnit.MILLISECONDS.convert(1000000, MICROSECONDS);
        l = TimeUnit.MILLISECONDS.convert(1000000, MILLISECONDS);
        System.out.println(l);
        final DelayQueue<CustomDelayed> delayeds = new DelayQueue<>();
        delayeds.offer(new CustomDelayed(System.nanoTime() + TimeUnit.NANOSECONDS.convert(15, TimeUnit.SECONDS)));

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    CustomDelayed delayed = delayeds.take();
                    System.out.println(222 + JSON.toJSONString(delayed));
                } catch (InterruptedException e) {
                    System.out.println(222 + "InterruptedException");
                }
            }
        });
        thread.start();
        try {
            thread.join(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            CustomDelayed delayed = delayeds.take();
            System.out.println(111 + JSON.toJSONString(delayed));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private static class CustomDelayed implements Delayed {
        private long time;
        private final long sequenceNumber;


        public CustomDelayed(long time) {
            this.time = time;
            this.sequenceNumber = sequencer.getAndIncrement();
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(time - System.nanoTime(), NANOSECONDS);
        }

        @Override
        public int compareTo(Delayed other) {
            if (other == this) // compare zero if same object
                return 0;
            if (other instanceof CustomDelayed) {
                CustomDelayed x = (CustomDelayed)other;
                long diff = time - x.time;
                if (diff < 0)
                    return -1;
                else if (diff > 0)
                    return 1;
                else if (sequenceNumber < x.sequenceNumber)
                    return -1;
                else
                    return 1;
            }
            long diff = getDelay(NANOSECONDS) - other.getDelay(NANOSECONDS);
            return (diff < 0) ? -1 : (diff > 0) ? 1 : 0;
        }
    }


}
