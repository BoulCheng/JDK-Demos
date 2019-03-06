package com.zlb.reflect.proxy.pattern;

/**
 * Created by cat on 2017-02-27.
 * 代理模式sample-静态代理 缺点代码的方法越多，重复的代码就可能越多
 * 动态代理: 基于接口代理(JDK代理 针对有接口的类的接口方法)、基于继承代理(Cglib代理 无法对static、final类进行代理且无法对static、private方法进行代理)
 */
public class Client {

    public static void main(String[] args){
        Subject subject = new Proxy(new RealSubject());
        subject.request();
    }
}
