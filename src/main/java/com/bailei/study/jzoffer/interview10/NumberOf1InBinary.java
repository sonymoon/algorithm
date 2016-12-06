package com.bailei.study.jzoffer.interview10;

/**
 * Created by bailei on 16/12/6.
 */
public class NumberOf1InBinary {

    public int numberOf1(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                ++count;
            }
            n >>= 1;

        }
        return count;
    }


    /**
     * 解决1中负数边界死循环问题
     *
     * @param n
     * @return
     */
    public int numberOf2(int n) {
        int count = 0;
        int flag = 1;
        if (n == Integer.MIN_VALUE) {
            ++count;
            return 1; // -2147483648 补码为0x80000000
        }
        if (n < 0 && n > Integer.MIN_VALUE) {
            ++count;
            n = -n;
        }
        while (flag != 0) {//left shit 32 times, flag will be 0
            if ((n & flag) != 0) {
                ++count;
            }
            flag <<= 1;
        }
        return count;
    }

    public int numberOf3(int n) {
        int count = 0;
        while (n != 0) {
            n = (n - 1) & n;
            ++count;
        }
        return count;
    }



    public static void main(String[] args) {
        System.out.println(new NumberOf1InBinary().numberOf2(-11));
        System.out.println(new NumberOf1InBinary().numberOf3(-2147483648));
    }
}
