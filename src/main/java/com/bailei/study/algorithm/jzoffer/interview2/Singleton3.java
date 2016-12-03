package com.bailei.study.algorithm.jzoffer.interview2;

/**
 * Created by bailei on 16/12/3.
 * 多线程高效率实现
 */
public class Singleton3 {

    private static Object lock = new Object();

    private static Singleton3 instance;

    private Singleton3() {

    }

    public static Singleton3 getInstance() {
        if (instance == null) {
            synchronized (Singleton3.lock) {
                if (instance == null) {
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }
}
