# Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
# do it without any loop/recursion in O(1) runtime?
# https://en.wikipedia.org/wiki/Digital_root 是答案

class Solution:
    def addDigits(self, num):
        """
        :type num: int
        :rtype: int
        """
        if num == 0:
            return 0
        res = num % 9
        return res if res != 0 else 9