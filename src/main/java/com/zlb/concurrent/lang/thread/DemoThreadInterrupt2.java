package com.zlb.concurrent.lang.thread;

/**
 * @author Yuanming Tao
 * Created on 2019/5/5
 * Description
 */
public class DemoThreadInterrupt2 {


    public static void main(String[] args) {
        test();
    }

    public static void test() {


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 100000000; i++) {
                    System.out.println("2:" + i);
                }
            }
        }, "thread-2");
        thread.start();
        System.out.println("==========================================================================================1");
        thread.interrupt();
        System.out.println("==========================================================================================2");

    }
    /**
     * /Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/bin/java "-javaagent:/Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.jar=55253:/Applications/IntelliJ IDEA.app/Contents/bin" -Dfile.encoding=UTF-8 -classpath /Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre/lib/charsets.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre/lib/deploy.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre/lib/ext/cldrdata.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre/lib/ext/dnsns.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre/lib/ext/jaccess.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre/lib/ext/jfxrt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre/lib/ext/localedata.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre/lib/ext/nashorn.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre/lib/ext/sunec.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre/lib/ext/sunjce_provider.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre/lib/ext/sunpkcs11.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre/lib/ext/zipfs.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre/lib/javaws.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre/lib/jce.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre/lib/jfr.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre/lib/jfxswt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre/lib/jsse.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre/lib/management-agent.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre/lib/plugin.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre/lib/resources.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre/lib/rt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/lib/ant-javafx.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/lib/dt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/lib/javafx-mx.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/lib/jconsole.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/lib/packager.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/lib/sa-jdi.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/lib/tools.jar:/Users/zlb/IdeaProjects/lb/m/JDK8-Demos/target/classes:/Users/zlb/.m2/repository/com/alibaba/fastjson/1.2.56/fastjson-1.2.56.jar:/Users/zlb/.m2/repository/cglib/cglib/3.2.10/cglib-3.2.10.jar:/Users/zlb/.m2/repository/org/ow2/asm/asm/7.0/asm-7.0.jar:/Users/zlb/.m2/repository/org/apache/ant/ant/1.10.3/ant-1.10.3.jar:/Users/zlb/.m2/repository/org/apache/ant/ant-launcher/1.10.3/ant-launcher-1.10.3.jar com.zlb.concurrent.lang.thread.DemoThreadInterruptOnJoin
     * 2:0
     * ==========================================================================================1
     * 2:1
     * 2:2
     * ==========================================================================================2
     * 2:3
     * 2:4
     * 2:5
     * 2:6
     * 2:7
     * 2:8
     * 2:9
     * 2:10
     * 2:11
     * 2:12
     * 2:13
     * 2:14
     * 2:15
     * 2:16
     * 2:17
     * 2:18
     * 2:19
     * 2:20
     * 2:21
     * 2:22
     * 2:23
     * 2:24
     * 2:25
     * 2:26
     * 2:27
     * 2:28
     * 2:29
     * 2:30
     * 2:31
     * 2:32
     * 2:33
     * 2:34
     * 2:35
     * 2:36
     * 2:37
     * 2:38
     * 2:39
     * 2:40
     * 2:41
     * 2:42
     * 2:43
     * 2:44
     * 2:45
     * 2:46
     * 2:47
     * 2:48
     * 2:49
     * 2:50
     * 2:51
     * 2:52
     * 2:53
     * 2:54
     * 2:55
     * 2:56
     * 2:57
     * 2:58
     * 2:59
     * 2:60
     * 2:61
     * 2:62
     * 2:63
     * 2:64
     * 2:65
     * 2:66
     * 2:67
     * 2:68
     * 2:69
     * 2:70
     * 2:71
     * 2:72
     * 2:73
     * 2:74
     * 2:75
     * 2:76
     * 2:77
     * 2:78
     * 2:79
     * 2:80
     * 2:81
     * 2:82
     * 2:83
     * 2:84
     * 2:85
     * 2:86
     * 2:87
     * 2:88
     * 2:89
     * 2:90
     * 2:91
     * 2:92
     * 2:93
     * 2:94
     * 2:95
     * 2:96
     * 2:97
     * 2:98
     * 2:99
     * 2:100
     * 2:101
     * 2:10
     */
}
