class Solution:
    def isIsomorphic(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """

        def judge(s, t):
            if len(s) != len(t):
                return False
            dict = {}
            for i in range(len(s)):
                if s[i] in dict and dict[s[i]] != t[i]:
                    return False
                dict[s[i]] = t[i]
            imitate_str = ''
            for _s in s:
                imitate_str += dict[_s]
            return imitate_str == t

        return judge(s, t) and judge(t, s)



print(Solution().isIsomorphic('aa', 'ab'))
