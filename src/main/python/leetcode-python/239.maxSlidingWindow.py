# -*- coding: utf-8 -*-

class Solution(object):

    def maxSlidingWindow(self, nums, k):

        if k <= 0 or not nums:
            return []

        q = []
        result = []

        for i, v in enumerate(nums):

            while q and v > nums[q[-1]]:
                q.pop()  # 弹出比较小的值

            q.append(i)

            if q[0] == i - k:  # 虽然还是比较大，但已经不在此范围了需要弹出去
                q.pop(0)

            if i >= k - 1:
                result.append(nums[q[0]])

        return result


print Solution().maxSlidingWindow([7, 2, 4]
                                  , 2)
