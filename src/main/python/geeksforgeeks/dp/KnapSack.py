W = 50

val = [60, 100, 120]

weight = [10, 20, 30]

n = len(val)


def knapStack(W, val, weight, n):
    if n == 0 or W == 0:
        return 0

    if weight[n - 1] > W:
        return knapStack(W, val, weight, n - 1)

    return max(val[n - 1] + knapStack(W - weight[n - 1], val, weight, n - 1), knapStack(W, val, weight, n - 1))


print knapStack(W, val, weight, n)


def knapStack_dp(W, val, weight, n):
    dp = [[0 for y in range(W + 1)] for x in range(n + 1)]

    for i in range(n + 1):
        for w in range(W + 1):
            if i == 0:
                dp[i][w] = 0
            if w == 0:
                dp[i][w] = 0
            else:
                if weight[i - 1] > w:
                    dp[i][w] = dp[i - 1][w]
                else:
                    dp[i][w] = max(val[i - 1] + dp[i - 1][w - weight[i - 1]], dp[i - 1][w])
    return dp[n][w]


print knapStack_dp(W, val, weight, n)
