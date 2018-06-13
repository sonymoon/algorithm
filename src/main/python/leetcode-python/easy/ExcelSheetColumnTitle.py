class Solution(object):
    def convertToTitle(self, n):
        title = ''
        while n > 0:
            n -= 1
            title = "{}{}".format(
                chr(n % 26 + 65), title
            )
            n //= 26
        return title


print(Solution().convertToTitle(52))
