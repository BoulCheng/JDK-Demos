package com.zlb.collections.framework.list;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Yuanming Tao
 * Created on 2019/3/6
 * Description
 */
public class DemoCopyOnWriteArrayList {

    public static void main(String[] args) {

        //源码
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();

        copyOnWriteArrayList.add("1");
        copyOnWriteArrayList.remove("1");
        copyOnWriteArrayList.addIfAbsent("2");

        copyOnWriteArrayList.get(1);

        for (int i = 0, j = copyOnWriteArrayList.size(); i < j; i++) {
            copyOnWriteArrayList.get(1);
        }

        copyOnWriteArrayList.iterator();

    }
}
