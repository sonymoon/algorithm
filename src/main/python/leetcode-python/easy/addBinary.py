class Solution:
    def addBinary(self, a, b):
        """
        :type a: str
        :type b: str
        :rtype: str
        """
        if len(a) == 0 and len(b) == 0:
            return '0'
        i = len(a) - 1
        j = len(b) - 1
        ret = ''
        c = 0
        while i >= 0 or j >= 0 or c == 1:
            if i >= 0:
                c += int(a[i])
                i -= 1
            if j >= 0:
                c += int(b[j])
                j -= 1
            ret = str(c % 2) + ret
            c //= 2
        return ret


print(Solution().addBinary('1', '1'))
