package com.zlb.collections.framework.list;

import java.util.ArrayList;

/**
 * @author Yuanming Tao
 * Created on 2019/3/5
 * Description
 */
public class DemoArrayList {

    public static void main(String[] args) {


        //源码
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(1,1);
        arrayList.indexOf(1);
        arrayList.remove(1);
        arrayList.ensureCapacity(3);


        arrayList.iterator();
    }
}
