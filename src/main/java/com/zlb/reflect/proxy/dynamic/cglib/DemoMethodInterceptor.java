package com.zlb.reflect.proxy.dynamic.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by cat on 2017-02-27.
 */
public class DemoMethodInterceptor implements MethodInterceptor{
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("before in cglib");
        Object result = null;
        try{
//            result = method.invoke(obj, args); 错误
            result = proxy.invokeSuper(obj, args);
        }catch (Exception e){
            System.out.println("get ex:"+e.getMessage());
            throw e;
        }finally {
            System.out.println("after in cglib");
        }
        return result;
    }
}
