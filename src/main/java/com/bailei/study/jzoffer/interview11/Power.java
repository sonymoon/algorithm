package com.bailei.study.jzoffer.interview11;

/**
 * Created by bailei on 16/12/6.
 * 计算幂方
 */
public class Power {

    public double power(double x, int y) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return x;
        }

        int exponent = y;
        if (y < 0) {
            exponent = -exponent;
        }

        return y < 0 ?
                1.0 / powerWithUnsigned(x, exponent)
                : powerWithUnsigned(x, exponent);

    }


    private double powerWithUnsigned(double x, int y) {
        if (y == 0) {
            return 1;
        }
        if (y == 1) {
            return x;
        }

        double result = powerWithUnsigned(x, y >> 1);
        result *= result;
        if ((y & 0x1) == 1) { //奇数
            result *= x;
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(new Power().power(2, 4));
        System.out.println(new Power().power(2, -4));
        System.out.println(new Power().power(0, 4));
        System.out.println(new Power().power(-2, -4));
        System.out.println(new Power().power(-2, -3));
        System.out.println(new Power().power(-2, 3));
        System.out.println(new Power().power(2, 3));
    }
}
