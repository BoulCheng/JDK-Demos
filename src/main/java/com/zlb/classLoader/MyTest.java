package com.zlb.classLoader;
public class MyTest {

    /**
     * 同一个类加载器，同一个类只会被加载一次
     * 类初始化只进行一次（前提是被同一类加载器加载)
     * @param args
     */
    public static void main(String[] args) {
        try {

            // 加载并初始化
            Class.forName("com.zlb.classLoader.ClassForName");
            System.out.println("#########分割符(上面是Class.forName的加载过程，下面是ClassLoader的加载过程)##########");
//         只加载不初始化   ClassLoader.getSystemClassLoader().loadClass("com.zlb.classLoader.ClassForName");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
