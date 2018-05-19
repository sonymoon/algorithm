class Solution:
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """

        if(len(nums) < 2):
            return []
        table = {}
        for i in range(len(nums)):
            complement = target - nums[i]
            if complement in table and table[complement] != i:
                return [table[complement], i]
            else:
                table[nums[i]] = i

        return []


print(Solution().twoSum([3, 3], 6))
