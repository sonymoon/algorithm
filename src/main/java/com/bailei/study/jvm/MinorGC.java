package com.bailei.study.jvm;

/**
 * Created by bailei on 16/12/23.
 * VM args -verbose:gc -Xms20m -Xmx20m －Xmn10m -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseSerialGC
 */
public class MinorGC {

    public static final int _MB = 1024 * 1024;

    public void testAllocation() {
        byte[] big1 , big2, big3, big4;
        big1 = new byte[4 * _MB];
        big2 = new byte[4 * _MB];
        big3 = new byte[4 * _MB];
        big4 = new byte[4 * _MB];
    }

    public static void main(String[] args) {
        new MinorGC().testAllocation();
    }
}
