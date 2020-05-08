package com.zlb.serializable.id;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试 同一对象序列化多次序列化到同一个文件反序列化出来后是否都相同
 *
 *
 * java的序列化机制采用了如下的算法:
 * a.所有保存到磁盘中的对象都有一个序列化编号
 * b.当程序试图序列化一个对象时，程序将检查该对象是否被序列化过，只有该对象从未被序列化（在本次虚拟机中）过，系统才会将该对象转化为字节序列输出。
 * c.如果某个对象已经被序列化过了，程序只是输出一个序列化编号，而不是重新序列化该对象。
 */
public class WriteReadTest {
    public static void main(String[] args) throws Exception {
        List<Person> students=new ArrayList<Person>();
        students.add(new Person("孙悟空",500));
        students.add(new Person("猪八戒",400));
        students.add(new Person("沙僧",300));

        Teacher teacher1=new Teacher("唐僧",students);
        Teacher teacher2=new Teacher("玄奘",students);
        //开始序列化对象
        FileOutputStream fos=new FileOutputStream(new File("serializableTest.out"));
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(students);
        oos.writeObject(teacher1);
        oos.writeObject(teacher2);

        //开始反序列化对象
        FileInputStream fis=new FileInputStream(new File("serializableTest.out"));
        ObjectInputStream ois=new ObjectInputStream(fis);
        List<Person> s=(List<Person>)ois.readObject();
        Teacher t1=(Teacher)ois.readObject();
        Teacher t2=(Teacher)ois.readObject();

        System.out.println(s==t1.students);//true
        System.out.println(s==t2.students);//true
        System.out.println(t1==t2);//false



        // students序列化到不同文件反序化出来是否是同一个
        fos=new FileOutputStream(new File("serializableTest222.out"));
        oos=new ObjectOutputStream(fos);
        oos.writeObject(students);

        fis=new FileInputStream(new File("serializableTest222.out"));
        ois=new ObjectInputStream(fis);
        List<Person> s222 = (List<Person>) ois.readObject();
        System.out.println(s == s222);

        Object oo = ois.readObject();
        oo = ois.readObject();

    }
}