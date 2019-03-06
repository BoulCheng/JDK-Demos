package com.zlb.clone;

import java.io.*;

/**
 * @author Yuanming Tao
 * Created on 2019/3/4
 * Description
 */
public class DemoClone implements Cloneable {

    public static void main(String[] args) {
        //1 shallow copy (primitive fields or references to immutable objects 是完全新的，references to mutable objects 是相同的，这就是浅拷贝)
        //1.1 must implements Cloneable
        //this method creates a new instance of the class of this
        //     * object and initializes all its fields with exactly the contents of
        //     * the corresponding fields of this object, as if by assignment; the
        //     * contents of the fields are not themselves cloned. Thus, this method
        //     * performs a "shallow copy" of this object, not a "deep copy" operation.
        DemoClone demoClone = new DemoClone();
        DemoClone demoClone1;
        try {
            demoClone1 = (DemoClone)demoClone.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        //1.2 Note that all arrays
        //     * are considered to implement the interface {@code Cloneable} and that
        //     * the return type of the {@code clone} method of an array type {@code T[]}
        //     * is {@code T[]} where T is any reference or primitive type
        String[] strArr = new String[]{"1", "2", "3"};
        String[] strArr1 = strArr.clone();

        //2 deep copy
        //By convention, the object returned by this method should be independent
        //     * of this object (which is being cloned).
        //To achieve this independence,
        //     * it may be necessary to modify one or more fields of the object returned
        //     * by {@code super.clone} before returning it
        //Typically, this means
        //     * copying any mutable objects that comprise the internal "deep structure"
        //     * of the object being cloned and replacing the references to these
        //     * objects with references to the copies.
        //If a class contains only
        //     * primitive fields or references to immutable objects(e.g., String), then it is usually
        //     * the case that no fields in the object returned by {@code super.clone}
        //     * need to be modified.
        //2.1 深拷贝需要replacing the references to these mutable objects with references to the copies.
        Teacher teacher = new Teacher("王老师", "英语");
        Student student = new Student("小明", 11, teacher);
        Student clone = null;
        try {
            clone = (Student) student.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return;
        }
        clone.setName("小强");
        clone.setAge(20);
        clone.getTeacher().setName("李老师");

        System.out.println(student.getName() + " " + student.getAge());
        System.out.println(clone.getName() + " " + clone.getAge());
        System.out.println(clone.getTeacher() == student.getTeacher());
        System.out.println(clone.getTeacher().getName() + " " + student.getTeacher().getName());

        //2.2 序列化实现深克隆 Java可以把对象序列化写进一个流里面，反之也可以把对象从序列化流里面读取出来，但这一进一出，这个对象就不再是原来的对象了
        Teacher teacher2 = new Teacher("王老师", "英语");
        StudentSerializable studentSerializable = new StudentSerializable("小明", 11, teacher2);
        StudentSerializable clone2 = null;
        try {
            clone2 = studentSerializable.serializableClone();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println(clone2.getTeacher() == studentSerializable.getTeacher());


    }

     static class Student implements Cloneable {

         private String name;
         private int age;
         private Teacher teacher;

         public Student(String name, int age, Teacher teacher) {
             this.name = name;
             this.age = age;
             this.teacher = teacher;
         }

         /**
          * 重写Object的Clone方法并在方法中调用super.clone()
          * @return
          * @throws CloneNotSupportedException
          */
         @Override
         protected Object clone() throws CloneNotSupportedException {
             Student student = null;
             try {
                 student = (Student) super.clone();
                 //为了实现深克隆
                 //1 克隆对象里面的对象类型也必须实现Cloneable接口
                 //2 并调用clone()，
                 //3 replacing the references to these mutable objects with references to the copies
//                 Teacher teacher = this.teacher.clone();
//                 student.setTeacher(teacher);
             } catch (CloneNotSupportedException e) {
                 e.printStackTrace();
             }
             return student;
         }

         public String getName() {
             return name;
         }

         public void setName(String name) {
             this.name = name;
         }

         public int getAge() {
             return age;
         }

         public void setAge(int age) {
             this.age = age;
         }

         public Teacher getTeacher() {
             return teacher;
         }

         public void setTeacher(Teacher teacher) {
             this.teacher = teacher;
         }
     }

     static class Teacher implements Cloneable, Serializable {
         private static final long serialVersionUID = 1L;

         private String name;
         private String course;

         public Teacher(String name, String course) {
             this.name = name;
             this.course = course;
         }

//         /**
//          * 为了实现深克隆
//          * @return
//          */
//         @Override
//         public Teacher clone() {
//
//             Teacher clone = null;
//             try {
//                 clone = (Teacher) super.clone();
//             } catch (CloneNotSupportedException e) {
//                 e.printStackTrace();
//             }
//             return clone;
//         }

         public String getName() {
             return name;
         }

         public void setName(String name) {
             this.name = name;
         }

         public String getCourse() {
             return course;
         }

         public void setCourse(String course) {
             this.course = course;
         }
     }

    static class StudentSerializable implements Serializable {
        private static final long serialVersionUID = 1L;

        private String name;
        private int age;
        private Teacher teacher;

        public StudentSerializable(String name, int age, Teacher teacher) {
            this.name = name;
            this.age = age;
            this.teacher = teacher;
        }

        /**
         * 如果一个可序列化的对象包含对某个不可序列化的对象的引用，那么整个序列化操作将会失败，并且会抛出一个NotSerializableException.
         * Teacher必须实现序列化接口
         *
         * 非静态内部类拥有对外部类的所有成员的完全访问权限，包括实例字段和方法。为实现这一行为，非静态内部类存储着对外部类的实例的一个隐式引用。序列化时要求所有的成员变量是Serializable,现在外部的类并没有implements Serializable,所以就抛出java.io.NotSerializableException异常
         * @return
         * @throws IOException
         * @throws ClassNotFoundException
         */
        public StudentSerializable serializableClone() throws IOException, ClassNotFoundException {
            StudentSerializable clone;

            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            ObjectOutputStream oo = new ObjectOutputStream(bo);
            oo.writeObject(this);
            ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
            ObjectInputStream oi = new ObjectInputStream(bi);
            clone = (StudentSerializable) oi.readObject();

            return clone;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public Teacher getTeacher() {
            return teacher;
        }

        public void setTeacher(Teacher teacher) {
            this.teacher = teacher;
        }
    }

}
