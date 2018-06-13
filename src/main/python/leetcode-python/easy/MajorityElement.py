class Solution:
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        dict = {x: 0 for x in nums[:]}
        for x in nums[:]:
            dict[x] += 1
        list = [(k, v) for k, v in dict.items()]
        return sorted(list, key=lambda x : x[1], reverse=True)[0][0]

print(Solution().majorityElement([3, 2, 3]))