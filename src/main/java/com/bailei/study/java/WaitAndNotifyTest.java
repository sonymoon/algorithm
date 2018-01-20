package com.bailei.study.java;

/**
 * Created by bailei on 17/1/30.
 */
public class WaitAndNotifyTest {

    public static void main(String[] args) throws InterruptedException {
        new WaitAndNotifyTest().wait1();
    }

    public synchronized void wait1() throws InterruptedException {
        this.wait(20000);
    }
}
