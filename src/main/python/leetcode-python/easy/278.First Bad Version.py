# The isBadVersion API is already defined for you.
# @param version, an integer
# @return a bool
def isBadVersion(version):
    """
    :type version: int
    :rtype: bool
    """
    return False


class Solution:
    def firstBadVersion(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n == 0:  # for test case pass
            return 1
        low, high = 1, n

        while low <= high:
            mid = (low + high) // 2
            if not isBadVersion(mid - 1) and isBadVersion(mid):
                return mid
            if not isBadVersion(mid):
                low = mid + 1
            else:
                high = mid - 1