#!/usr/bin/python
# -*- coding: UTF-8 -*-

# Given a 32-bit signed integer, reverse digits of an integer.


class Solution:

    max32BitsNum = 1 << 31

    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        if x > Solution.max32BitsNum - 1 or x < -Solution.max32BitsNum:
            return 0
        if x > -10 and x < 10:
            return x

        isNeg = False
        if x < 0:
            x = -x
            isNeg = True

        val = x % 10
        x = x // 10
        while x != 0:
            val = val * 10 + x % 10
            x = x // 10
        val = val if val >= -Solution.max32BitsNum and val <= Solution.max32BitsNum - 1 else 0
        return -val if isNeg else val
