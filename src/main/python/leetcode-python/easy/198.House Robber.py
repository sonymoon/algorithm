class Solution:
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        if n < 2:
            return nums[0] if n == 1 else 0
        dp = [0, 0]
        dp[0] = nums[0]
        dp[1] = max(nums[1], nums[0])
        for i in range(2, n):
            dp[0], dp[1] = dp[1], max(dp[1], dp[0] + nums[i])
        return dp[1]


print(Solution().rob([2, 7, 9, 3, 1]))
