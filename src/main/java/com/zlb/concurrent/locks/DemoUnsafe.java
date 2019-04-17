package com.zlb.concurrent.locks;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author Yuanming Tao
 * Created on 2019/3/17
 * Description
 */
public class DemoUnsafe {

    public static void main(String[] args) {
//        Unsafe unsafe = Unsafe.getUnsafe();
//        System.out.println(1);

        Unsafe unsafe;
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            unsafe = (Unsafe) f.get(null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
