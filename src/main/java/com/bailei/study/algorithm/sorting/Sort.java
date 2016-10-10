package com.bailei.study.algorithm.sorting;

/**
 * Created by bailei on 2016/8/26.
 */
public interface Sort {

    void sort(Comparable[] a);

    default boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }


    default boolean greater(Comparable a, Comparable b) {
        return a.compareTo(b) > 0;
    }

    default void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    default boolean isSorted(Comparable a[]) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i + 1])) {
                return false;
            }
        }
        return true;
    }
}
