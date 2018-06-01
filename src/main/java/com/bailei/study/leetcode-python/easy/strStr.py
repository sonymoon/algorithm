class Solution:
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        if not needle:
            return 0

        char = needle[0]
        ix = -1
        for j in range(len(haystack)):
            if haystack[j] == char:
                ix = j
                if ix - 1 + len(needle) > len(haystack) - 1:
                    return -1
                else:
                    for n in range(1, len(needle)):
                        if haystack[j+n] != needle[n]:
                            ix = -1
                if ix != -1:
                    return ix
        return ix


print(Solution().strStr('', 'abc'))
