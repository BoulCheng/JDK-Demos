package com.zlb.collections.framework.map;

import com.alibaba.fastjson.JSON;

/**
 * @author Yuanming Tao
 * Created on 2019/2/27
 * Description
 */
public class DemoWeakHashMap {


    public static void main(String[] args) {
        Object object = new Object();
        java.util.WeakHashMap weakHashMap = new java.util.WeakHashMap();
        weakHashMap.put(object, "demo");
        System.gc();
        System.out.println(JSON.toJSONString(weakHashMap));

        //使key没有强引用
        object = null;
        //触发一次gc
        System.gc();
        System.out.println(JSON.toJSONString(weakHashMap));

        weakHashMap.put(new String("String"), "demo");
        System.gc();
        System.out.println(JSON.toJSONString(weakHashMap));

        //same sequence of characters, 都为String, 但两个key并不同，
        //This class is intended primarily for use with key objects whose equals methods test for object identity using the == operator.
        // Once such a key is discarded it can never be recreated
        weakHashMap.put(new String("String"), "demo");
        System.out.println(JSON.toJSONString(weakHashMap));

        weakHashMap.put("String2", "demo");
        //常量无法gc
        System.gc();
        System.out.println(JSON.toJSONString(weakHashMap));

        weakHashMap.put("String2", "demo2");
        System.out.println(JSON.toJSONString(weakHashMap));


        String st3 = "String3";
        weakHashMap.put(st3, "demo");
        st3 = null;
        System.gc();
        System.out.println(JSON.toJSONString(weakHashMap));

        /**
         * {{}:"demo"}
         * {}
         * {}
         * {"String":"demo"}
         * {"String2":"demo"}
         * {"String2":"demo2"}
         * {"String2":"demo2","String3":"demo"}
         */
    }

}

