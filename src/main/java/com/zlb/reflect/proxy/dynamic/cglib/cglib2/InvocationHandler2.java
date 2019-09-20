package com.zlb.reflect.proxy.dynamic.cglib.cglib2;

import com.zlb.reflect.proxy.pattern.RealSubject;
import net.sf.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

/**
 * @author Yuanming Tao
 * Created on 2019/8/19
 * Description
 */
public class InvocationHandler2 implements InvocationHandler {
    private RealSubject realSubject;

    public InvocationHandler2(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("InvocationHandler2-method:" + method.getName());
        return method.invoke(this.realSubject, objects);
    }
}
