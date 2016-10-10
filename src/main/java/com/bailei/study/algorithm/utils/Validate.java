package com.bailei.study.algorithm.utils;

/**
 * Created by bailei on 2016/9/25.
 */
public class Validate {
    public static void isTrue(final boolean expression, final String message, final Object... values) {
        if (expression == false) {
            throw new IllegalArgumentException(String.format(message, values));
        }
    }
}
