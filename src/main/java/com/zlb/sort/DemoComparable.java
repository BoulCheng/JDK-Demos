package com.zlb.sort;

import java.util.TreeSet;

/**
 * @author Yuanming Tao
 * Created on 2019/3/1
 * Description
 */
public class DemoComparable {

    public static void main(String[] args) {


        TreeSet treeSet = new TreeSet();
        // treeSet 内部实现是 treeMap , treeSet.add实际调用的是treeMap的put方法
        treeSet.add(new Integer(1));

        Integer a = 1;
        Integer b = 1;
        float i = Math.signum(a.compareTo(b));

        System.out.println(i);
    }
}
