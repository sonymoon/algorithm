class Solution:
    def mySqrt(self, x):
        """
        :type x: int
        :rtype: int
        """
        if x < 0:
            raise Exception('not illeage x')
        if x == 0:
            return 0
        if x == 1:
            return 1

        right = (x + 1) // 2 + 1
        left = 0

        while left <= right:
            mid = left + (right - left) // 2
            if mid > x // mid:
                right = mid - 1
            else:
                if mid + 1 > x // (mid+1):
                    return mid
                left = mid + 1

        return left - 1


print(Solution().mySqrt(4294967297))
