package com.zlb.concurrent.atomic;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author Yuanming Tao
 * Created on 2019/4/8
 * Description
 */
public class DemoAtomicStampedReference {


    public static void main(String[] args) {
        AtomicStampedReference<Foo> asr = new AtomicStampedReference<>(new Foo(), 0);
        int[] stamp = new int[1];
        Foo  oldRef = asr.get(stamp);
        // 调用get方法获取引用对象和对应的版本号
        int oldStamp = stamp[0];
        // stamp[0]保存版本号
        boolean b = asr.compareAndSet(oldRef, new Foo(), oldStamp, oldStamp + 1);
        System.out.println(b);
        //尝试以CAS方式更新引用对象，并将版本号+1
    }

    static class Foo {

    }
}
