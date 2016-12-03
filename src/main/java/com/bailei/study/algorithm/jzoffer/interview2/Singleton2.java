package com.bailei.study.algorithm.jzoffer.interview2;

/**
 * Created by bailei on 16/12/3.
 * 多线程考虑，但效率不高
 */
public class Singleton2 {

    private static Object lock = new Object();

    private static Singleton2 instance;

    private Singleton2() {

    }

    public static Singleton2 getInstance() {
        synchronized (Singleton2.lock) {
            if (instance == null) {
                instance = new Singleton2();
            }
        }
        return instance;
    }
}
