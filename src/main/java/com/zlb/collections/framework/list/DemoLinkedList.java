package com.zlb.collections.framework.list;

import java.util.*;

/**
 * @author Yuanming Tao
 * Created on 2019/3/6
 * Description
 */
public class DemoLinkedList {

    public static void main(String[] args) {

        //源码
        LinkedList<String> linkedList = new LinkedList<>();

        linkedList.add("1");
        linkedList.addLast("3");
        linkedList.addFirst("2");
        linkedList.add(2, "4");

        linkedList.getFirst();
        linkedList.getLast();
        linkedList.get(1);

        linkedList.remove("1");
        linkedList.remove(1);
        linkedList.removeFirst();
        linkedList.removeLast();

        linkedList.listIterator();


        /**
         * Iterator生成调用链依次调用
         *
         * @see AbstractSequentialList#iterator()
         * @see AbstractList#listIterator()
         * @see LinkedList#listIterator(int)
         *
         */
        Iterator<String> listIterator = linkedList.iterator();
        listIterator.hasNext();
    }
}
