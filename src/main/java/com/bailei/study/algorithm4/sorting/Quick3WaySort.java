package com.bailei.study.algorithm4.sorting;

import com.bailei.study.utils.ArrayUtil;
import com.bailei.study.utils.StdRandom;

import static java.lang.System.currentTimeMillis;

/**
 * Created by bailei on 2016/10/12.
 */
public class Quick3WaySort implements Sort {

    @Override
    public void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int i = lo + 1, lt = lo, gt = hi;
        Comparable v = a[lo];
        while (gt >= i) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) {
                exch(a, i++, lt++);
            } else if (cmp == 0) {
                i++;
            } else {
                exch(a, i, gt--);
            }
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }


    public static void main(String[] args) {
        Sort sort = new Quick3WaySort();
        Comparable[] a = new Comparable[10];
        long curTime = currentTimeMillis();
        sort.sort(ArrayUtil.randomInit(a));
        ArrayUtil.print(a, curTime);
    }
}
