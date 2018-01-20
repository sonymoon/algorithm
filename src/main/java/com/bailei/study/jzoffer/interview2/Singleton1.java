package com.bailei.study.jzoffer.interview2;

/**
 * Created by bailei on 16/12/3.
 * 单例模式的第一种不好解法
 */
public class Singleton1 {

    private static Singleton1 instance = null;

    private Singleton1() {

    }


    public static Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }


}
