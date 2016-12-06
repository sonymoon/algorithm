package com.bailei.study.jzoffer.interview9;

/**
 * Created by bailei on 16/12/6.
 */
public class Fibonacci {

    public long fionacciRecursive(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fionacciRecursive(n - 1) + fionacciRecursive(n - 2);
    }

    public long fibonacciWithFori(int n) {
        int[] result = {0, 1};
        if (n < 2) {
            return result[n];
        }
        long bn = 0;
        long bn2 = 0;
        long bn1 = 1;
        for (int i = 1; i < n; i++) {
            bn = bn2 + bn1;

            bn2 = bn1;
            bn1 = bn;
        }
        return bn;
    }

    public static void main(String[] args) {
        System.out.println(new Fibonacci().fionacciRecursive(50));
        System.out.println(new Fibonacci().fibonacciWithFori(50));
    }
}
