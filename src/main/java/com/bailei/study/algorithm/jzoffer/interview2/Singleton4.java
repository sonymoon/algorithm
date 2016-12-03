package com.bailei.study.algorithm.jzoffer.interview2;

/**
 * Created by bailei on 16/12/3.
 * 类加载时 实例化, 不用多线程
 */
public class Singleton4 {

    private static Singleton4 instance = new Singleton4();

    private Singleton4() {

    }

    public static Singleton4 getInstance() {
        return instance;
    }
}
