package com.zlb.reflect.proxy.ref;

import java.lang.ref.*;

public class ReferenceTest {

    public static void main(String[] args) {


             String str = new String("hello"); //①
             ReferenceQueue<String> rq = new ReferenceQueue<String>(); //②
             WeakReference<String> wf = new WeakReference<String>(str, rq); //③
//        PhantomReference<String> wf = new PhantomReference<String>(str, rq); //③
//        SoftReference<String> wf = new SoftReference<String>(str, rq); //③
             str=null; //④取消"hello"对象的强引用
             String str1=wf.get(); //⑤假如"hello"对象没有被回收，str1引用"hello"对象
        str1 = null;
             //假如"hello"对象没有被回收，rq.poll()返回null
             Reference<? extends String> ref=rq.poll(); //⑥
        ref = null;
        System.gc();
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        str1=wf.get();
        ref = rq.poll();
        System.out.println(ref);
    }
}
