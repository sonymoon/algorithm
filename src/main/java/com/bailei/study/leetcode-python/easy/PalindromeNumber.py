class Solution:
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        if x < 0:
            return False
        if x <= 9:
            return True

        val = x % 10
        if val == 0:
            return False

        x = x // 10
        while val < x:
            val = val * 10 + x % 10
            x //= 10

        return val == x or x == val // 10
