package com.bailei.study.algorithm.sorting;

import com.bailei.study.algorithm.utils.ArrayUtil;

import static java.lang.System.currentTimeMillis;

/**
 * Created by bailei on 2016/10/11.
 */
public class ShellSort implements Sort {
    @Override
    public void sort(Comparable[] a) {
        int n = a.length;
        int h = 1;
        while (h < n / 3) { // sequence of h ordered
            h = h * 3 + 1;
        }
        while (h >= 1) {
            for (int i = h; i < a.length; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }


    public static void main(String[] args) {
        Sort sort = new ShellSort();
        Comparable[] a = new Comparable[1000];
        long curTime = currentTimeMillis();
        sort.sort(ArrayUtil.randomInit(a));
        ArrayUtil.print(a, curTime);
        assert sort.isSorted(a);
    }
}
