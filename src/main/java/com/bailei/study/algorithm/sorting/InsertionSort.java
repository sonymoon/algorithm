package com.bailei.study.algorithm.sorting;

/**
 * Created by bailei on 2016/8/25.
 */
public class InsertionSort {

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


    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        int a[] = new int[]{5, 2, 4, 6, 1, 3};
        insertionSort.incrSort(a);
        for (int i : a) {
            System.out.print(i + ", ");
        }
        System.out.println();
        insertionSort.descSort(a);
        for (int i : a) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }

}
