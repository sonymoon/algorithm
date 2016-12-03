package com.bailei.study.algorithm4.sorting;

import com.bailei.study.utils.ArrayUtil;

import static java.lang.System.currentTimeMillis;

/**
 * Created by bailei on 2016/10/11.
 */
public class MergeSort implements Sort {

    private Comparable[] buf;

    @Override
    public void sort(Comparable[] a) {
        buf = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);

    }


    private void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            buf[k] = a[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = buf[j++];
            } else if (j > hi) {
                a[k] = buf[i++];
            } else if (less(buf[i], buf[j])) {
                a[k] = buf[i++];
            } else {
                a[k] = buf[j++];
            }
        }
    }


    public static void main(String[] args) {
        Sort sort = new MergeSort();
        Comparable[] a = new Comparable[10];
        long curTime = currentTimeMillis();
        sort.sort(ArrayUtil.randomInit(a));
        ArrayUtil.print(a, curTime);
        assert sort.isSorted(a);
    }
}
