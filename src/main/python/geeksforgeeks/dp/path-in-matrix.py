def pathInMatrix(result, matrix, i, j, m, n):
    if i >= 0 and j >= 0:
        result.append(matrix[i][j])

    if 0 <= i - 1 < m and 0 <= j < n and matrix[i - 1][j] - matrix[i][j] == 1:
        pathInMatrix(result, matrix, i - 1, j, m, n)
    if 0 <= i < m and 0 <= j + 1 < n and matrix[i][j + 1] - matrix[i][j] == 1:
        pathInMatrix(result, matrix, i, j + 1, m, n)
    if 0 <= i + 1 < m and 0 <= j < n and matrix[i + 1][j] - matrix[i][j] == 1:
        pathInMatrix(result, matrix, i + 1, j, m, n)
    if 0 <= i - 1 < m and 0 <= j - 1 < n and matrix[i - 1][j - 1] - matrix[i][j] == 1:
        pathInMatrix(result, matrix, i - 1, j - 1, m, n)
    return result


def main(matrix):
    m = len(matrix)
    if m == 0:
        return
    n = len(matrix[0])

    result = []
    for i in range(m):
        for j in range(n):
            result.append(pathInMatrix([], matrix, i, j, m, n))
    max0 = 0
    maxLength = 0
    for x in range(len(result)):
        if len(result[x]) > maxLength:
            maxLength = len(result[x])
            max0 = x

    if result:
        print(result[max0])
        return len(result[max0])
    return 0

matrix = [
    [1, 2, 9],
    [5, 3, 8],
    [4, 6, 7]
]

print main(matrix)
