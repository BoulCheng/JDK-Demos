package com.zlb.serializable;

import java.io.Serializable;

/**
 * @author Yuanming Tao
 * Created on 2019/3/4
 * Description
 */
public class DemoNonStaticNestedClass implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * DemoNonSerializableEntity没有序列化，InnerClass也可以序列化成功
     */
    public DemoNonSerializableEntity demoNonSerializableEntity;

    class InnerClass implements Serializable {
        private static final long serialVersionUID = 1L;

        String s;

        public String getSs() {
            return s;
        }

        public void setSs(String ss) {
            this.s = ss;
        }
    }

    public DemoNonSerializableEntity getDemoNonSerializableEntity() {
        return demoNonSerializableEntity;
    }

    public void setDemoNonSerializableEntity(DemoNonSerializableEntity demoNonSerializableEntity) {
        this.demoNonSerializableEntity = demoNonSerializableEntity;
    }
}
