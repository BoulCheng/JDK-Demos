package com.zlb.serializable;

import com.zlb.clone.DemoClone;

import java.io.*;

/**
 * @author Yuanming Tao
 * Created on 2019/3/4
 * Description
 */
public class DemoSerializableInnerClass {

    public static void main(String[] args) {
        //An instance of InnerClass can exist only within an instance of OuterClass and has direct access to the methods and fields of its enclosing instance.
        //To instantiate an inner class, you must first instantiate the outer class. Then, create the inner object within the outer object with this syntax:
        //OuterClass.InnerClass innerObject = outerObject.new InnerClass();

        DemoNonStaticNestedClass demoNonStaticNestedClass = new DemoNonStaticNestedClass();
        demoNonStaticNestedClass.setDemoNonSerializableEntity(new DemoNonSerializableEntity());

        DemoNonStaticNestedClass.InnerClass innerClass = demoNonStaticNestedClass.new InnerClass();
        DemoNonStaticNestedClass.InnerClass clone = new DemoSerializableInnerClass().serializableClone(innerClass);

        System.out.println(clone == innerClass);
        System.out.println(clone);

    }

    /**
     * 非静态内部类拥有对外部类的所有成员的完全访问权限，包括实例字段和方法。
     * 为实现这一行为，非静态内部类存储着对外部类的实例的一个隐式引用。
     * 序列化时要求所有的成员变量是Serializable,现在外部的类并没有implements Serializable,所以就抛出java.io.NotSerializableException异常。
     * DemoNonStaticNestedClass 必须序列化
     * @param innerClass
     * @return
     */
    public DemoNonStaticNestedClass.InnerClass serializableClone(DemoNonStaticNestedClass.InnerClass innerClass) {
        DemoNonStaticNestedClass.InnerClass clone = null;

        try {
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            ObjectOutputStream oo = new ObjectOutputStream(bo);
            oo.writeObject(innerClass);
            ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
            ObjectInputStream oi = new ObjectInputStream(bi);
            clone = (DemoNonStaticNestedClass.InnerClass) oi.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return clone;
    }
}
