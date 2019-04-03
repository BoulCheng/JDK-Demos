package com.zlb.concurrent.executor;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Yuanming Tao
 * Created on 2019/3/26
 * Description
 */
public class DemoBitOperation {

    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;

    // runState is stored in the high-order bits
    private static final int RUNNING    = -1 << COUNT_BITS;
    private static final int SHUTDOWN   =  0 << COUNT_BITS;
    private static final int STOP       =  1 << COUNT_BITS;
    private static final int TIDYING    =  2 << COUNT_BITS;
    private static final int TERMINATED = 3 << COUNT_BITS;

    /**
     * 负数的二进制以正数的补码表示
     * 原码：一个整数按照绝对值的大小转化成二进制的数
     * 反码：将二进制数按位取反
     * 补码：反码加 1
     *
     * private static final int RUNNING    = -1 << 29;
     * ==================================================
     * 0000 0000 0000 0000 0000 0000 0000 0001	(-1原码)
     *
     * 1111 1111 1111 1111 1111 1111 1111 1110 (取反得反码)
     *
     * 1111 1111 1111 1111 1111 1111 1111 1111	(+1得补码)
     *
     * 1110 0000 0000 0000 0000 0000 0000 0000 (左移29位)
     *
     * 1101 1111 1111 1111 1111 1111 1111 1111 (-1得反码)
     *
     * 0010 0000 0000 0000 0000 0000 0000 0000 (取反得原码) RUNNING = - (1的(30-1)次方) = - 536870912
     *
     * @param args
     */

    public static void main(String[] args) {
        System.out.println(RUNNING);
        System.out.println(SHUTDOWN);
        System.out.println(STOP);
        System.out.println(TIDYING);
        System.out.println(TERMINATED);
        System.out.println(CAPACITY);

        System.out.println("=====");

        int c = ctlOf(RUNNING, 0);
        System.out.println(c);
        int i = workerCountOf(c);
        System.out.println(i);
    }

    private static int ctlOf(int rs, int wc) { return rs | wc; }
    private static int workerCountOf(int c)  { return c & CAPACITY; }


}
