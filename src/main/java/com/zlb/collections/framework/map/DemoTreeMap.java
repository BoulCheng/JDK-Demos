package com.zlb.collections.framework.map;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * @author Yuanming Tao
 * Created on 2019/3/8
 * Description
 */
public class DemoTreeMap {

    public static void main(String[] args) {

        TreeMap treeMap = new TreeMap(new ComparatorM());


        treeMap.put("1", 1);

    }

    static class ComparatorM implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            return 0;
        }
    }

}
