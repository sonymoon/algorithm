class Solution:
    def containsNearbyDuplicate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: bool
        """
        _set = set([])
        for i in range(len(nums)):
            if i > k:
                _set.remove(nums[i - k - 1])
            if nums[i] in _set:
                return True
            else:
                _set.add(nums[i])
        return False
