package com.zlb.serializable.Objects;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author Yuanming Tao
 * Created on 2019/7/9
 * Description
 */
public class Test {


    public static void main(String[] args) {

        SerializableObject serializableObject = new SerializableObject();
        serializableObject.setI(1000);
        serializableObject.setS("zlb");

        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("/Users/zlb/IdeaProjects/lb/m/JDK8-Demos/file/object.txt"));
            objectOutputStream.writeObject(serializableObject);



        } catch (IOException e) {
            e.printStackTrace();
        }




    }

}
