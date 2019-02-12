class Solution:
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: int
        """
        dic = {}
        for c in s:
            if c not in dic:
                dic[c] = 1
            else:
                dic[c] += 1

        hasOdd = False
        length = 0
        for k, v in dic.items():
            if v % 2 != 0:
                hasOdd = True
                length += v - 1
            else:
                length += v
        return length + (1 if hasOdd else 0)

print(Solution().longestPalindrome('bb'))