package com.bailei.study.designPattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class EchoServiceInvocationHandler implements InvocationHandler {

    private Object realObject;

//    private Object realObject1;  可以传别的接口实现类的实例


    public EchoServiceInvocationHandler(Object realObject) {
        this.realObject = realObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // pre process
        //....
        //可以在之前做些预处理的逻辑，如参数校验等，方法比较等
        //....
        if (method.getName().equals("realObject的方法")) {
            //这里用反射，拿到method参数后，直接调用这个方法，
            // 传进来的这个realObject对象, 肯定是有这个method对应的方法签名的
            return method.invoke(realObject, args);
        } else {
//            return method.invoke(realObject1, args);
        }
        return method.invoke(realObject, args);
    }
}
