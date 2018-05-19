package com.bailei.study.designPattern.proxy;

import java.lang.reflect.Proxy;

public class JdkProxyClientTest {
    public static void main(String[] args) {
        //这里直接强转类型为EchoService
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        EchoService echoService = (EchoService) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                new Class[]{EchoService.class},
                new EchoServiceInvocationHandler(new EchoServiceImpl()));
        System.out.println(echoService.echo("jdk proxy test"));
        System.out.println(echoService.echoNone());
    }
}
