package com.zlb.reflect.proxy.dynamic.cglib.cglib2;

import com.zlb.reflect.proxy.dynamic.cglib.DemoMethodInterceptor;
import com.zlb.reflect.proxy.pattern.RealSubject;
import com.zlb.reflect.proxy.pattern.Subject;
import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

/**
 * Created by cat on 2017-02-27.
 */
public class Client2 {

    /**
     * 调用方法的时候router到InvocationHandler或者MethodInterceptor。为什么会有两种呢，因为CGLIB提供了filter的机制，可以让不同的方法代理到不同的callback中
     * @param args
     */
    public static void main(String[] args){
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/zlb/IdeaProjects/lb/m/JDK8-Demos/com/sun/proxy/cglib2");

        RealSubject realSubject = new RealSubject();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(RealSubject.class);
        enhancer.setCallbacks(new Callback[]{new DemoMethodInterceptor2(realSubject), new InvocationHandler2(realSubject)});
        enhancer.setCallbackFilter(new CallbackFilter() {
            @Override
            public int accept(Method method) {
                //返回的下标和在Callback数组中的下标对应,下面表达的是reduce方法绑定MethodInterceptor
                return method.getName().equals("request") ? 1 : 0;
            }

        });
        Subject subject = (Subject) enhancer.create();

        subject.request();


        subject.hello();

    }
}
