package com.bailei.study.designPattern.proxy;

/**
 * Created by bailei on 2018/1/20 下午3:51
 */
public class EchoServiceImpl implements EchoService{
    @Override
    public String echo(String str) {
        return str;
    }

    @Override
    public String echoNone() {
        return "none";
    }
}
