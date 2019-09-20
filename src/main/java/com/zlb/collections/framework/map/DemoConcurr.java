package com.zlb.collections.framework.map;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Yuanming Tao
 * Created on 2019/4/23
 * Description
 */
public class DemoConcurr {


    public static void main(String[] args) {
        test3();
    }

    public static void test() {

        ConcurrentHashMap<KeyObject, String> concurrentHashMap2 = new ConcurrentHashMap<>(32);
        concurrentHashMap2.put(new KeyObject("1"), "1");
        concurrentHashMap2.put(new KeyObject("1"), "2");

    }


    public static void test2() {

        Integer[] integers = new Integer[9];
        int i = integers.length;
        System.out.println(i);

        ConcurrentHashMap<KeyObject, String> concurrentHashMap2 = new ConcurrentHashMap<>(32);
        concurrentHashMap2.put(new KeyObject("1"), "1");
        concurrentHashMap2.put(new KeyObject("1"), "2");

        concurrentHashMap2.put(new KeyObject("1"), "3");
        concurrentHashMap2.put(new KeyObject("1"), "3");

        concurrentHashMap2.put(new KeyObject("1"), "3");
        concurrentHashMap2.put(new KeyObject("1"), "3");

        concurrentHashMap2.put(new KeyObject("1"), "3");
        concurrentHashMap2.put(new KeyObject("1"), "3");

        concurrentHashMap2.put(new KeyObject("1"), "3");

    }


    public static void test3() {

        ConcurrentHashMap<KeyObject, String> concurrentHashMap2 = new ConcurrentHashMap<>(4); //8
        concurrentHashMap2.put(new KeyObject("1"), "1");
        concurrentHashMap2.put(new KeyObject("1"), "2");

        concurrentHashMap2.put(new KeyObject("1"), "3");
        concurrentHashMap2.put(new KeyObject("1"), "3");

        concurrentHashMap2.put(new KeyObject("1"), "3");
        concurrentHashMap2.put(new KeyObject("1"), "3");//扩容2倍 16

        concurrentHashMap2.put(new KeyObject("1"), "3");
        concurrentHashMap2.put(new KeyObject("1"), "3");

        concurrentHashMap2.put(new KeyObject("1"), "3");//判断是否需要树化 //该条件下该bin不会树化 且会调用tryPresize 把table的length扩大8倍 即变为128
        concurrentHashMap2.put(new KeyObject("1"), "3");

    }



    static final void testResizeStamp(int n) {
        int rs = resizeStamp(16);
        int i = (rs << RESIZE_STAMP_SHIFT) + 2;
        System.out.println(i);
    }

    static final int resizeStamp(int n) {

        int i = Integer.numberOfLeadingZeros(n);

        /**
         *
         * 0000 0000 0000 0000 1000 0000 0000 0000
         *
         *
         * 0000 0000 0000 0000 0000 0000 0000 0100
         *
         */
        return  i | (1 << (RESIZE_STAMP_BITS - 1));
    }

    private static int RESIZE_STAMP_BITS = 16;
    private static final int RESIZE_STAMP_SHIFT = 32 - RESIZE_STAMP_BITS;


}
