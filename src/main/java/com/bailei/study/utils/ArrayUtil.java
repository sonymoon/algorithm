package com.bailei.study.utils;

import java.awt.*;

import static java.lang.System.currentTimeMillis;

/**
 * Created by bailei on 2016/8/25.
 */
public class ArrayUtil {

    public static Comparable[] randomInit(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = RandomUtils.nextInt(1, a.length);

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

    public static void draw(Comparable[] a, int m, int n) {
        StdDraw.clear();
        double length = a.length + 2;
        double max = 0;
        for (Comparable i : a) {
            Integer in = (Integer) i;
            if (max < in) {
                max = in;
            }
        }
        for (int i = 0; i < a.length; i++) {
            if (i == m) {
                StdDraw.setPenColor(Color.CYAN);
            } else if (i == n) {
                StdDraw.setPenColor(Color.RED);
            } else {
                StdDraw.setPenColor(Color.BLACK);
            }
            StdDraw.line((i + 1) / length, .0, (i + 1) / length, (Integer) a[i] / max);
        }
        StdDraw.line((a.length + 1) / length, .0, (a.length + 1) / length, .0);
        StdDraw.show();
        StdDraw.pause(1000);
    }

    public static void main(String[] args) {
        StdDraw.setScale(-2, +2);
        StdDraw.enableDoubleBuffering();

        for (double t = 0.0; true; t += 0.02) {
            double x = Math.sin(t);
            double y = Math.cos(t);
            StdDraw.clear();
            StdDraw.filledCircle(x, y, 0.05);
            StdDraw.filledCircle(-x, -y, 0.05);
            StdDraw.show();
            StdDraw.pause(20);
        }
    }
}
