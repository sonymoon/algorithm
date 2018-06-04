class Solution:
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        length = len(nums)
        if length == 1:
            return 1
        i = 0
        j = 1
        while j < length:
            if(nums[i] == nums[j]):
                j += 1
            else:
                i += 1
                nums[i] = nums[j]
                j += 1
        return i+1


print(Solution().removeDuplicates([1, 1]))
