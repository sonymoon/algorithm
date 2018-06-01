class Solution:
    def countAndSay(self, n):
        """
        :type n: int
        :rtype: str
        """
        if n <=1:
            return '1'

        s = self.countAndSay(n-1)
        if s == '1':
            return '11'
        prev = s[0]
        count = 1
        temp = ''
        for i in range(1, len(s)):
            if prev != s[i]:
                temp += str(count) + prev
                prev = s[i]
                count = 1
            else:
                count += 1
        temp += str(count) + prev
        s = temp
        return s