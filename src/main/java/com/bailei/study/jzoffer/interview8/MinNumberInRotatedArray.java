package com.bailei.study.jzoffer.interview8;

/**
 * Created by bailei on 16/12/5.
 */
public class MinNumberInRotatedArray {

    public int min(int a[]) {
        if (a.length < 1) {
            return 0;
        }
        if (a.length == 1) return a[0];
        int p = 0, q = a.length - 1;
        while (q - p != 1) {
            int half = (q + p) / 2;
            if (a[p] <= a[half]) { // in the first child array
                p = half;
            } else if (a[half] < a[q]) {
                q = half;
            }
        }

        return a[q];
    }

    public static void main(String[] args) {
        int[] array = {7, 8, 1, 2, 3, 3, 4, 5, 6, 7};
        System.out.println(new MinNumberInRotatedArray().min(array));
    }

}
