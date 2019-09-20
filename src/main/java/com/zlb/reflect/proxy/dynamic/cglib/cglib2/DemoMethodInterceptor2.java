package com.zlb.reflect.proxy.dynamic.cglib.cglib2;

import com.zlb.reflect.proxy.pattern.RealSubject;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by cat on 2017-02-27.
 */
public class DemoMethodInterceptor2 implements MethodInterceptor{
    private RealSubject realSubject;

    public DemoMethodInterceptor2(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("before in cglib-method:" + method.getName());
        Object result = null;
        try{
            result = method.invoke(this.realSubject, args);
//            result = proxy.invokeSuper(obj, args);
        }catch (Exception e){
            System.out.println("get ex:"+e.getMessage());
            throw e;
        }finally {
            System.out.println("after in cglib");
        }
        return result;
    }
}
