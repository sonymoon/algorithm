class Solution:
    def isHappy(self, n):
        """
        :type n: int
        :rtype: bool
        """
        encounted = set()
        while True:
            h = 0
            while n > 0:
                d = n % 10
                h += d ** 2
                n = n // 10
            if h == 1:
                return True
            elif h in encounted:
                return False
            n = h
            encounted.add(h)


print(Solution().isHappy(19))
