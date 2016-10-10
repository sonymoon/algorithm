package com.bailei.study.algorithm.leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bailei on 2016/9/25.
 */
public class TwoSum implements Answer {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if (nums.length < 2) {
            return result;
        }
        //a map container (key)minus + (value)num[i] = target
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(target - nums[i])) {
                map.put(nums[i], i);
            } else {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
            }
        }
        return result;
    }
}
