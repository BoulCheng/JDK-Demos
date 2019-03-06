package com.zlb.collections.framework.map;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Yuanming Tao
 * Created on 2019/2/27
 * Description
 * @since 1.8
 */
public class DemoConcurrentHashMap {

    public static void main(String[] args) {
        //源码
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(31);
        concurrentHashMap.put("111", "33e");

    }
}
