def main(matrix):
    n = len(matrix)
    dp = [[-1] * n for x in range(n)]

    result = -1

    for i in range(n):
        for j in range(n):
            if dp[i][j] == -1:
                findLongestPathFromCell(matrix, n, i, j, dp)

            result = max(dp[i][j], result)

    return result


def findLongestPathFromCell(matrix, n, i, j, dp):

    if (i < 0 or i >= n) or (j < 0 or j >= n):
        return 0

    if dp[i][j] != -1:
        return dp[i][j]

    if i - 1 >= 0 and matrix[i][j] + 1 == matrix[i - 1][j]:
        dp[i][j] = 1 + findLongestPathFromCell(matrix, n, i - 1, j, dp)
        return dp[i][j]

    if j + 1 < n and (matrix[i][j] + 1 == matrix[i][j + 1]):
        dp[i][j] = 1 + findLongestPathFromCell(matrix, n, i, j + 1, dp)
        return dp[i][j]

    if i + 1 < n and matrix[i][j] + 1 == matrix[i + 1][j]:
        dp[i][j] = 1 + findLongestPathFromCell(matrix, n, i + 1, j, dp)
        return dp[i][j]

    if j - 1 >= 0 and matrix[i][j] + 1 == matrix[i][j - 1]:
        dp[i][j] = 1 + findLongestPathFromCell(matrix, n, i, j - 1, dp)
        return dp[i][j]
    # no increasing diff order 1 found
    dp[i][j] = 1
    return dp[i][j]


matrix = [
    [1, 2, 9],
    [5, 3, 8],
    [4, 6, 7]
]

print main(matrix)