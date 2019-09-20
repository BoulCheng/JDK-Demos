package com.zlb.collections.framework.map;

import java.io.Serializable;

/**
 * @author Yuanming Tao
 * Created on 2019/4/22
 * Description ConcurrentHashMap 的key
 */
public class KeyObject implements Serializable {
    private static final long serialVersionUID = 5650819360713262640L;

    private String s;

    private Integer i;

    public KeyObject(String s) {
        this.s = s;
    }

    @Override
    public int hashCode() {
        return s.hashCode();
    }

    /**
     * 为满足测试 ConcurrentHashMap 的hash碰撞，此处破坏了equals方法的一般约定，即equals相等hashCode也相等
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public Integer getI() {
        return i;
    }

    public void setI(Integer i) {
        this.i = i;
    }
}
