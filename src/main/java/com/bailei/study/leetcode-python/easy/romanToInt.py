class Solution:

    def __init__(self):
        self.__dict = {}
        self.__dict['I'] = 1
        self.__dict['V'] = 5
        self.__dict['X'] = 10
        self.__dict['L'] = 50
        self.__dict['C'] = 100
        self.__dict['D'] = 500
        self.__dict['M'] = 1000

    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """
        ret = 0
        for i in range(len(s) - 1):
            ret += self.__dict[s[i]] if self.__dict[s[i]] >= self.__dict[s[i + 1]] else -self.__dict[s[i]]
        ret += self.__dict[s[-1]]
        return ret