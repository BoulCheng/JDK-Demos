package com.zlb.serializable.id;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.List;

public class Teacher implements Serializable {
    public String name;
    public List<Person> students=null;
    public Teacher(String name,List<Person> students)
    {
        this.name=name;
        this.students=students;
    }


}