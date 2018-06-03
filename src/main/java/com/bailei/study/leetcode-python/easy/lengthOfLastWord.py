class Solution:
    def lengthOfLastWord(self, s):
        """
        :type s: str
        :rtype: int
        """
        if not s:
            return 0

        firstCharIx = -1
        for i in reversed(range(len(s))):
            if s[i] != ' ':
                firstCharIx = i
                break

        firstSpace = -1
        for j in reversed(range(firstCharIx)):
            if s[j] == ' ':
                firstSpace = j
                break

        return firstCharIx - firstSpace


assert Solution().lengthOfLastWord('') == 0
assert Solution().lengthOfLastWord(' ') == 0
assert Solution().lengthOfLastWord('abc ') == 3
assert Solution().lengthOfLastWord(' abc ') == 3
assert Solution().lengthOfLastWord(' abc abc abcd') == 4
assert Solution().lengthOfLastWord(' abc abc abcd abc') == 3
