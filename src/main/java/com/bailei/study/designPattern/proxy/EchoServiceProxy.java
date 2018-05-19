package com.bailei.study.designPattern.proxy;

/**
 * Created by bailei on 2018/1/20 下午3:51
 */
public class EchoServiceProxy implements EchoService {

    private EchoService echoService;

    public EchoServiceProxy(EchoService echoService) {
        this.echoService = echoService;
    }

    @Override
    public String echo(String str) {
        String s = echoService.echo(str);
        return "proxy object: " + s;
    }

    @Override
    public String echoNone() {
        String s = echoService.echoNone();
        return "proxy object: " + s;
    }
}
