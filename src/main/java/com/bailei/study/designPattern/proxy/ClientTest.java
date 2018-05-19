package com.bailei.study.designPattern.proxy;

/**
 * Created by bailei on 2018/1/20 下午3:54
 */
public class ClientTest {
    public static void main(String[] args) {
        EchoService echoService = new EchoServiceProxy(new EchoServiceImpl());
        System.out.println(echoService.echoNone());
        System.out.println(echoService.echo("echo msg"));
    }
}
