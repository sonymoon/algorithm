package com.bailei.study.java;

/**
 * Created by bailei on 17/1/31.
 */
public class EggProblem {

    public static void main(String[] args) {
        int result = 0;
        for (int i = 0; i < 10000; i += 9) {
            if (i % 2 != 1) continue;
            if (i % 3 != 0) continue;
            if (i % 4 != 1) continue;
            if (i % 5 != 4) continue;
            if (i % 6 != 3) continue;
            if (i % 7 != 0) continue;
            if (i % 8 != 1) continue;
            result = i;
            break;
        }
        System.out.println(result);
    }
}
