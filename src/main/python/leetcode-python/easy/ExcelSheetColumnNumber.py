class Solution:
    def titleToNumber(self, s):
        """
        :type s: str
        :rtype: int
        """
        sum = 0
        for char in s:
            sum = sum * 26 + (ord(char) - 64)
        return sum


print(Solution().titleToNumber("AB"))