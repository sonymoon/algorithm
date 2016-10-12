package com.bailei.study.algorithm.sorting;

import com.bailei.study.algorithm.utils.ArrayUtil;
import com.bailei.study.algorithm.utils.StdRandom;

import static java.lang.System.currentTimeMillis;

/**
 * Created by bailei on 2016/10/11.
 */
public class QuickSort implements Sort {

    private void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private int partition(Comparable[] a, int lo, int hi) {
        Comparable v = a[lo];
        int i = lo;
        int j = hi + 1;
        while (j > i) {
            while (less(a[++i], v)) if (i == hi) break;
            while (less(v, a[--j])) if (j == lo) break;
            if (j > i) exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    @Override
    public void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }


    public static void main(String[] args) {
        Sort sort = new QuickSort();
        Comparable[] a = new Comparable[10];
        long curTime = currentTimeMillis();
        sort.sort(ArrayUtil.randomInit(a));
        ArrayUtil.print(a, curTime);
    }

}
