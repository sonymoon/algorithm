class Solution:
    def maxSubArray(self, nums):
        if not nums:
            return 0
        _sum = nums[0]
        _max = _sum
        for i in range(1, len(nums)):
            _sum = max(_sum + nums[i], nums[i])
            _max = max(_sum , _max)
        return _max
