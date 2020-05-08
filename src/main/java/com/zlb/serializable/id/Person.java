package com.zlb.serializable.id;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class Person implements Serializable {
    public String name;
    public int age;
    public Person(){
        System.out.println("Person的无参构造器");
    }
    public Person(String name,int age)
    {
        this.name=name;
        this.age=age;
    }
    public String toString(){
        return "name:"+name+",age:"+age;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        System.out.println("Person的clone方法里");
        return super.clone();
    }



//
//    Object readResolve() throws ObjectStreamException {
//        return null;
//    }
//
//    Object writeReplace() throws ObjectStreamException {
//        return null;
//    }

}