package com.bailei.study.algorithm.sorting;

import com.bailei.study.algorithm.utils.ArrayUtil;

import static java.lang.System.currentTimeMillis;

/**
 * Created by bailei on 2016/8/26.
 */
public class SelectionSort implements Sort {

    @Override
    public void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (less(a[j], a[minIndex])) {
                    minIndex = j; //找到不变式a[j...n]最小的
                }
            }
            if (minIndex != i) { //最小不在 不变式中
                exch(a, minIndex, i);
            }
        }
    }


    public static void main(String[] args) {
        Sort selectionSort = new SelectionSort();
        Comparable[] bigTable = new Comparable[1024];
        long curTime = currentTimeMillis();
        selectionSort.sort(ArrayUtil.randomInit(bigTable));
        ArrayUtil.print(bigTable, curTime);
    }
}
