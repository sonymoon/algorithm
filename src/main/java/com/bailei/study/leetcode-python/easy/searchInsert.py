class Solution:
    def searchInsert(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """

        if not nums:
            return 0

        i = 0
        j = len(nums) - 1
        while i <= j:
            mid = (j + i) // 2
            if nums[mid] < target:
                i = mid + 1
            if nums[mid] > target:
                j = mid - 1
            if target == nums[mid]:
                return mid
        return i    


s = Solution()
assert s.searchInsert([2, 7, 8, 9, 10], 9)
assert s.searchInsert([1, 3], 0) == 0
assert s.searchInsert([1, 3], 1) == 0
assert s.searchInsert([1, 3], 2) == 1
assert s.searchInsert([1, 3], 3) == 1

assert s.searchInsert([1, 3, 5], 0) == 0
assert s.searchInsert([1, 3, 5], 1) == 0
assert s.searchInsert([1, 3, 5], 2) == 1
assert s.searchInsert([1, 3, 5], 3) == 1
assert s.searchInsert([1, 3, 5], 4) == 2
assert s.searchInsert([1, 3, 5], 5) == 2
assert s.searchInsert([1, 3, 5], 6) == 3

assert s.searchInsert([1, 3, 5, 7], 0) == 0
assert s.searchInsert([1, 3, 5, 7], 1) == 0
assert s.searchInsert([1, 3, 5, 7], 2) == 1
assert s.searchInsert([1, 3, 5, 7], 3) == 1
assert s.searchInsert([1, 3, 5, 7], 4) == 2
assert s.searchInsert([1, 3, 5, 7], 5) == 2
assert s.searchInsert([1, 3, 5, 7], 6) == 3
assert s.searchInsert([1, 3, 5, 7], 7) == 3
assert s.searchInsert([1, 3, 5, 7], 8) == 4
