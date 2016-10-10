package com.bailei.study.algorithm.utils;

import java.util.Random;

/**
 * Created by bailei on 2016/9/25.
 */
public class RandomUtils {

    private static final Random RANDOM = new Random();


    public static int nextInt(final int startInclusive, final int endExclusive) {
        Validate.isTrue(endExclusive >= startInclusive,
                "Start value must be smaller or equal to end value.");
        Validate.isTrue(startInclusive >= 0, "Both range values must be non-negative.");

        if (startInclusive == endExclusive) {
            return startInclusive;
        }

        return startInclusive + RANDOM.nextInt(endExclusive - startInclusive);
    }
}
