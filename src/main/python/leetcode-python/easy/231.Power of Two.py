class Solution:
    def isPowerOfTwo(self, n):
        """
        :type n: int
        :rtype: bool
        """
        i = 0
        while 2 ** i < n:
            i += 1
        return 2 ** i == n

    def isPowerOfTwo1(self, n):
        """
        :type n: int
        :rtype: bool
        """
        return True if  n & (n-1) == 0 and n != 0 else False

print(Solution().isPowerOfTwo(16))