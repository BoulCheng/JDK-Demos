package com.zlb.reflect.proxy.dynamic.cglib;

import com.zlb.reflect.proxy.pattern.RealSubject;
import com.zlb.reflect.proxy.pattern.Subject;
import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

/**
 * Created by cat on 2017-02-27.
 */
public class Client {

    public static void main(String[] args){
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/zlb/IdeaProjects/lb/m/JDK8-Demos/com/sun/proxy/cglib");

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(RealSubject.class);
        enhancer.setCallback(new DemoMethodInterceptor());
        Subject subject = (Subject) enhancer.create();
        subject.hello();
    }
}
