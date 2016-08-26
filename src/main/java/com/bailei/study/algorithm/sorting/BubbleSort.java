package com.bailei.study.algorithm.sorting;

import com.bailei.study.algorithm.utils.ArrayUtil;

import static java.lang.System.currentTimeMillis;

/**
 * Created by bailei on 2016/8/26.
 */
public class BubbleSort implements Sort {
    @Override
    public void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = a.length - 1; j > i; j--) {
                if (a[j] < a[j - 1]) {         //不变式 a[0 ... i], a[i+1..n] 不断把最小的往左冒泡
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Sort sort = new BubbleSort();
        int[] bigTable = new int[1024];
        long curTime = currentTimeMillis();
        sort.sort(ArrayUtil.randomInit(bigTable));
        ArrayUtil.print(bigTable, curTime);
    }
}
