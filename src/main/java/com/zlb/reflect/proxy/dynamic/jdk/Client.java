package com.zlb.reflect.proxy.dynamic.jdk;

import com.zlb.reflect.proxy.pattern.RealSubject;
import com.zlb.reflect.proxy.pattern.Subject;
import sun.misc.ProxyGenerator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
 * Created by cat on 2017-02-27.
 */
public class Client {

    public static void main(String[] args){
        //保存生成的字节码 com.sun.proxy.$Proxy0
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        /**
         * 依次调用
         * {@link java.lang.reflect.Proxy#newProxyInstance(ClassLoader, Class[], InvocationHandler)}
         * @see java.lang.reflect.Proxy#getProxyClass0(ClassLoader, Class[])
         * @see java.lang.reflect.Proxy.ProxyClassFactory#apply(ClassLoader, Class[])
         * @see sun.misc.ProxyGenerator#generateProxyClass(String, Class[], int)
         */
        Subject subject = (Subject) Proxy.newProxyInstance(Client.class.getClassLoader(), new Class[]{Subject.class}, new JdkProxySubject(new RealSubject()));
        subject.hello();
    }
}
