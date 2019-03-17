package com.zlb.locks;

/**
 * @author Yuanming Tao
 * Created on 2019/3/16
 * Description
 */
public class TestNull {


    private transient volatile A head;

    private transient volatile A tail;

    public static void main(String[] args) {


        TestNull testNull = new TestNull();

        //两个赋值为null的变量使用 == 判断返回true
        boolean bb = testNull.head != testNull.tail;
        //false
        System.out.println(bb);

    }
}
