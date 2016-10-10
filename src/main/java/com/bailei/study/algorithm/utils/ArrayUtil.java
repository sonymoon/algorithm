package com.bailei.study.algorithm.utils;

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
    public static long print(Object[] obj, long time) {
        long diff = currentTimeMillis() - time;
        System.out.println("costs " + diff + " ms ");
        StringBuilder str = new StringBuilder();
        for (Object o : obj) {
            str.append(o + ", ");
        }
        System.out.println(str);
        return System.currentTimeMillis();
    }
}
