package com.zlb.collections.framework.map;

import java.util.*;

/**
 * @author Yuanming Tao
 * Created on 2019/3/8
 * Description
 */
public class DemoLinkedHashMap {

    public static void main(String[] args) {

        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("1", 1);
        linkedHashMap.put("2", 2);
        linkedHashMap.put("3", 3);

        linkedHashMap.entrySet().iterator();

        Map copy = new LinkedHashMap(new HashMap());

        Map copy2 = new HashMap(new HashMap());


        TreeMap map = new TreeMap();
        map.put("1", 2);

//        LinkedHashMap.Entry<K,V> p = (LinkedHashMap.Entry<K,V>)e, b = p.before, a = p.after;


        testAccessOrder();

        testEvict();

    }


    private static void testAccessOrder() {
        Map<String, String> map = new LinkedHashMap<String, String>(16,0.75f,true);
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");
        map.put("4", "e");

        //testAccessOrder
        map.get("1");
        map.get("2");


        for (Iterator<String> iterator = map.values().iterator(); iterator.hasNext(); ) {
            String name = (String) iterator.next();
            System.out.print(name);
        }
    }

    /**
     * 未test
     */
    private static void testEvict() {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");
        map.put("4", "e");
        map.put("5", "d");


        EvictedLinkedHashMap evictedLinkedHashMap = new EvictedLinkedHashMap(map);
        evictedLinkedHashMap.put("6", "d");
        System.out.println(evictedLinkedHashMap);

    }

    static class EvictedLinkedHashMap<K, V> extends LinkedHashMap {

        public EvictedLinkedHashMap(Map m) {
            super(m);
        }

        public EvictedLinkedHashMap(int initialCapacity, float loadFactor, boolean accessOrder) {
            super(initialCapacity, loadFactor, accessOrder);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return true;
        }
    }
}
