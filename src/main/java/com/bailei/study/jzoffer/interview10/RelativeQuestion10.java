package com.bailei.study.jzoffer.interview10;

/**
 * Created by bailei on 16/12/6.
 */
public class RelativeQuestion10 {

    public static boolean isPowerOf2(int n) {
        return ((n - 1) & n) == 0;
    }

    public static int numberOfDiffBitsBetween(int n, int m) {
        return new NumberOf1InBinary().numberOf3(n ^ m);
    }

    public static void main(String[] args) {
        System.out.println(isPowerOf2(128));
        System.out.println(isPowerOf2(127));
        System.out.println(numberOfDiffBitsBetween(9, 10));
        System.out.println(0.0000 == 0.0);
    }
}
