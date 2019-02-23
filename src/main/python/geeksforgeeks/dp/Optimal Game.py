def optimalGame(arr):
    n = len(arr)
    n = len(arr)

    dp = [[0] * n for x in range(n)]  # store value between i j , user's optimal result

    for gap in range(n):
        for j in range(gap, n):
            i = j - gap
            if i == j:
                dp[i][j] == arr[i]
            if j == i + 1:
                dp[i][j] = max(arr[i], arr[j])
            x = 0
            if i + 2 <= j:
                x = dp[i + 2][j]
            y = 0
            if i + 1 <= j - 1:
                y = dp[i + 1][j - 1]
            z = 0
            if i <= j - 2:
                z = dp[i][j - 2]
            dp[i][j] = max(arr[i] + min(x, y),
                           arr[j] + min(y, z))
    return dp[0][n - 1]


arr1 = [8, 15, 3, 7]
print optimalGame(arr1)

arr2 = [2, 2, 2, 2]
print optimalGame(arr2)

arr3 = [20, 30, 2, 2, 2, 10]
print optimalGame(arr3)
