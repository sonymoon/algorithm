
# Given an integer n, return the number of trailing zeroes in n!.

# Example 1:

# Input: 3
# Output: 0
# Explanation: 3! = 6, no trailing zero.

# Example 2:

# Input: 5
# Output: 1
# Explanation: 5! = 120, one trailing zero.


class Solution:

    def trailingZeroes(self, n):
        """
        :type n: int
        :rtype: int
        """
        x = 5
        ans = 0
        while n >= x:
            ans += n // x
            x *= 5
        return ans



print(Solution().trailingZeroes(1808548329))
