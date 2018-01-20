package com.bailei.study.algorithm4.sorting;

import com.bailei.study.utils.ArrayUtil;

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
                ArrayUtil.draw(a, i, j);
            }
            if (minIndex != i) { //最小不在 不变式中
                ArrayUtil.draw(a, i, minIndex);
                exch(a, minIndex, i);
            }
        }
    }


    public static void main(String[] args) {
        Sort selectionSort = new SelectionSort();
        Comparable[] bigTable = new Comparable[10];
        long curTime = currentTimeMillis();
        selectionSort.sort(ArrayUtil.randomInit(bigTable));
        ArrayUtil.print(bigTable, curTime);
    }
}
