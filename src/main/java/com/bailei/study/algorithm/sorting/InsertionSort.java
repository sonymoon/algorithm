package com.bailei.study.algorithm.sorting;

import com.bailei.study.algorithm.utils.ArrayUtil;

import static java.lang.System.currentTimeMillis;

/**
 * Created by bailei on 2016/8/25.
 */
public class InsertionSort implements Sort {

    public void incrSort(int[] a) {

        for (int j = 1; j < a.length; j++) {
            int i = j - 1;
            int key = a[j];
            while (i >= 0 && a[i] > key) {
                a[i + 1] = a[i];
                a[i] = key;
                --i;
            }
        }
    }

    public void descSort(int a[]) {
        for (int j = a.length - 1 - 1; j >= 0; j--) {
            int i = j + 1;
            int temp = a[j];
            while (i < a.length && a[i] > temp) {
                a[i - 1] = a[i];
                a[i] = temp;
                i++;
            }
        }
    }

    @Override
    public void sort(int[] a) {

    }

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        int[] bigTable = new int[1024];
        long curTime = currentTimeMillis();
        insertionSort.incrSort(ArrayUtil.randomInit(bigTable));
        curTime = ArrayUtil.print(bigTable, curTime);
        insertionSort.descSort(ArrayUtil.randomInit(bigTable));
        ArrayUtil.print(bigTable, curTime);
    }


}
