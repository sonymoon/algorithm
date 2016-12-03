package com.bailei.study.jzoffer.interview2;

/**
 * Created by bailei on 16/12/3.
 * 类加载时 实例化, 不用多线程
 */
public class Singleton5 {

    private static Singleton5 instance = new Singleton5();

    private Singleton5() {

    }

    public static Singleton5 getInstance() {
        return instance;
    }
}
