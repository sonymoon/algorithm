class Solution:
    def singleNumber(self, nums):

        lastNumber = nums[0]
        doubleSum = lastNumber * 2
        for i in nums:
            if lastNumber!=