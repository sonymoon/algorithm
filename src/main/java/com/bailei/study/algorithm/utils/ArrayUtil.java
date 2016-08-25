package com.bailei.study.algorithm.utils;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.RandomUtils;

import static java.lang.System.currentTimeMillis;

/**
 * Created by bailei on 2016/8/25.
 */
public class ArrayUtil {

    public static int[] randomInit(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = RandomUtils.nextInt(0, a.length);
        }
        return a;
    }

    /**
     * @param obj
     * @param time 传入开始时间戳
     * @return
     */
    public static long print(Object obj, long time) {
        long diff = currentTimeMillis() - time;
        System.out.println("costs " + diff + " ms " + ArrayUtils.toString(obj));
        return System.currentTimeMillis();
    }
}
