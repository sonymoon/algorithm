package com.bailei.study.jzoffer.sort;

import com.bailei.study.algorithm4.sorting.Sort;
import com.bailei.study.utils.ArrayUtil;
import com.bailei.study.utils.RandomUtils;

import static java.lang.System.currentTimeMillis;

/**
 * Created by bailei on 16/12/5.
 * 自己实现的快速排序
 * using random partition element
 */
public class QuickSort implements Sort {


    @Override
    public void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private int partition(Comparable[] a, int lo, int hi) {
        int index = RandomUtils.nextInt(lo, hi + 1); //exclusive
        exch(a, index, lo); //选择的数字放到第一个元素位置
        Comparable v = a[lo];
        for (int i = lo, j = hi + 1; j > i; ) {
            while (greater(v, a[++i])) if (i == hi) break;
            while (greater(a[--j], v)) if (j == lo) break;
            if (j > i) {
                exch(a, i, j);
            }
            index = j;
        }
        exch(a, lo, index);
        return index;
    }

    public static void main(String[] args) {
        Sort sort = new QuickSort();
        Comparable[] a = new Comparable[20];
        long curTime = currentTimeMillis();
        sort.sort(ArrayUtil.randomInit(a));
        ArrayUtil.print(a, curTime);
    }

}
