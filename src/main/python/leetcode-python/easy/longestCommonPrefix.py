class Solution:
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        if len(strs) == 0 : return ''
        ret = ''
        shortLine = strs[0]
        for s in strs:
            if len(shortLine) > len(s):
                shortLine = s
        for i in range(len(shortLine)):
            isPrefix = True
            for j in range(len(strs)):
                if strs[j][i] != shortLine[i]:
                    isPrefix = False
                    break
            if isPrefix:
                ret += shortLine[i]
            elif i == 0:
                return ''
        return ret



print(Solution().longestCommonPrefix(["aca","cba"]))