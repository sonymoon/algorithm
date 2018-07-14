class Solution:
    def findNthDigit(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n < 10:
            return n
        maxBits = 1
        for i in range(1, 11):
            numberInbitsI = (10 ** i - 10 ** (i - 1)) * i
            if n <= numberInbitsI:
                maxBits = i
                break
            n -= numberInbitsI

        i = (n - 1) // maxBits
        j = (n - 1) % maxBits
        target = 10 ** (maxBits - 1) + i
        print('n maxBits i j target\n', n, maxBits, i, j, target)
        return int(str(target)[j])


print(Solution().findNthDigit(194))
