package com.bailei.study.algorithm.sorting;

import com.bailei.study.algorithm.utils.ArrayUtil;

import static java.lang.System.currentTimeMillis;

/**
 * Created by bailei on 2016/8/25.
 */
public class InsertionSort implements Sort {

    public void incrSort(Comparable[] a) {

        for (int j = 1; j < a.length; j++) {
            int i = j - 1;
            Comparable key = a[j];
            while (i >= 0 && greater(a[i], key)) {      //不变式a[j...n] 未排序，a[0...j-1]已排好序，key=a[j]不断往左边插入到合适的位置
                a[i + 1] = a[i];
                a[i] = key;
                ArrayUtil.draw(a, i, j);
                --i;
            }
        }
    }

    public void descSort(Comparable a[]) {
        for (int j = a.length - 1 - 1; j >= 0; j--) {
            int i = j + 1;
            Comparable temp = a[j];
            while (i < a.length && greater(a[i], temp)) {
                a[i - 1] = a[i];
                a[i] = temp;
                i++;
            }
        }
    }

    @Override
    public void sort(Comparable[] a) {
        incrSort(a);
    }

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        Comparable[] bigTable = new Comparable[20];
        long curTime = currentTimeMillis();
        insertionSort.sort(ArrayUtil.randomInit(bigTable));
        curTime = ArrayUtil.print(bigTable, curTime);
        insertionSort.descSort(ArrayUtil.randomInit(bigTable));
        ArrayUtil.print(bigTable, curTime);
    }


}
