class Solution:
    def generate(self, numRows):
        """
        :type numRows: int
        :rtype: List[List[int]]
        """
        result = []
        result.append([1])
        result.append([1, 1])
        for i in range(1, range(numRows)):
            row = [1]
            for j in range(1, i-1):
                row.append(result[i-1][j-1] + result[j])
            row.append(1)
        return result


