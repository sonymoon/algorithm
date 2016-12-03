package com.bailei.study.algorithm.jzoffer.interview2;

/**
 * Created by bailei on 16/12/3.
 * 按需实例化 不用多线程
 */
public class Singleton6 {


    private Singleton6() {

    }

    public static Singleton6 getInstance() {
        return Nested.instance;
    }


    private static class Nested {
        private static Singleton6 instance = new Singleton6();
    }
}
