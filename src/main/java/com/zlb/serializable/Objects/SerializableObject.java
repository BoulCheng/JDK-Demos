package com.zlb.serializable.Objects;

import java.io.Serializable;

/**
 * @author Yuanming Tao
 * Created on 2019/7/9
 * Description
 */
public class SerializableObject implements Serializable {

    private static final long serialVersionUID = 6433904184022148810L;
    private String s;

    private int i;

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}
