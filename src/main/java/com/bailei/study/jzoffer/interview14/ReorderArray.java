package com.bailei.study.jzoffer.interview14;

/**
 * Created by bailei on 16/12/9.
 */
public class ReorderArray {

    public void reorderOddEven(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int p = 0, q = array.length - 1;
        while (p < q) {
            while (p < q && (array[p] & 0x1) != 0) {
                ++p;
            }
            while (p < q && (array[q] & 0x1) == 0) {
                --q;
            }
            if (p < q) {
                array[q] = array[p] + array[q];
                array[p] = array[q] - array[p];
                array[q] = array[q] - array[p];
            }

        }


    }


    public static void main(String[] args) {
        int[] a = new int[]{2, 4, 6, 8, 1, 3, 5, 7};
        new ReorderArray().reorderOddEven(a);
        for (int i : a) {
            System.out.println(i);
        }
    }
}
