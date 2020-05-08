package com.zlb.serializable.Externalizable;

import java.io.*;

/**
 * 使用Externalizable来反序列化时，是调用反序列化的类的公共无参构造器，然后在readExternal方法中对成员变量赋值，而Serializable是不会调用任何构造器的
 */
public class Person implements Externalizable {
    public String name;
    public int age;
    public Person(){
        System.out.println("公共无参构造器");
    }
    public Person(String name,int age)
    {
        this.name=name;
        this.age=age;
    }
    /**
     * 在序列化的时候调用
     */
    @Override
    public void writeExternal(ObjectOutput out)
            throws IOException {
        out.writeObject(name);
        out.writeInt(age);
    }
    /**
     * 在反序列化的时候调用
     */
    @Override
    public void readExternal(ObjectInput in) throws IOException,
            ClassNotFoundException {
        this.name=(String)in.readObject();
        this.age=in.readInt();
    }


    public static void main(String[] args) throws Exception {
        Person p=new Person("孙悟空",500);
        //开始序列化对象
        FileOutputStream fos=new FileOutputStream(new File("person.out"));
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(p);
        //开始反序列化对象
        FileInputStream fis=new FileInputStream(new File("person.out"));
        ObjectInputStream ois=new ObjectInputStream(fis);
        Person p2=(Person)ois.readObject();
        System.out.println("name:"+p2.name+",age:"+p2.age);
    }
}