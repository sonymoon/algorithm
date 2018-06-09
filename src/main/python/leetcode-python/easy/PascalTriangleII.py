class Solution:
    def getRow(self, rowIndex):
        """
        :type rowIndex: int
        :rtype: List[int]
        """
        ret = [1 for _ in range(rowIndex + 1)]
        for i in range(2, rowIndex + 1):
            k = i//2 + 1 if i % 2 == 1 else i // 2
            for j in reversed(range(1, k + 1)):
                ret[j] = ret[j] + ret[j-1]
            if i % 2 == 0:
                ret = ret[0:k + 1] + ret[0:k][::-1]
            else:
                ret = ret[0:k] + ret[0:k][::-1]

        return ret
