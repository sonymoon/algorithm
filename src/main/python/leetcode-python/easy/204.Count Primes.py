class Solution:
    def countPrimes(self, n):
        """
        :type n: int
        :rtype: int
        """
        isprime = [True for _ in range(2, n)]
        isprime = [False for _ in range(2)] + isprime
        i = 1
        while (i + 1) * (i + 1) < n:
            i += 1
            if not isprime[i]:  # aready calculated
                continue
            j = i * i
            while j < n:
                isprime[j] = False
                j += i
        count = 0
        for i in range(1, n ):
            if isprime[i]:
                count += 1
        return count


print(Solution().countPrimes(100))
