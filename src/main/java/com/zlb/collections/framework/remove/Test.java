package com.zlb.collections.framework.remove;

import java.util.ArrayList;
import java.util.Iterator;

public class Test {
    public static void main(String[] args)  {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2);
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            Integer integer = iterator.next();
            iterator.remove();
//            if(integer==2)
//                list.remove(integer);
        }
    }
}