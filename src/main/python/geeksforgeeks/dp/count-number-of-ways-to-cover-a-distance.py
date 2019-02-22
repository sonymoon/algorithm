# coding:utf-8
# Given a distance ‘dist, count total number of ways to cover the distance with 1, 2 and 3 steps.

# 递归解法
def countDistStepsWays(dist):
    if dist < 0:
        return 0
    if dist == 0:
        return 1
    else:
        return countDistStepsWays(dist - 1) + countDistStepsWays(dist - 2) + countDistStepsWays(dist - 3)


# dp with arr[] to store results
def countDistStepsWaysDp(dist):
    dp = [0 for x in range(dist + 1)]
    for i in range(dist + 1):
        if i == 0:
            dp[i] = 0
        elif i == 1:
            dp[i] = dp[i - 1] + 1
        elif i == 2:
            dp[i] = dp[i - 1] + dp[i - 2] + 1
        else:
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3] + 1
    return dp[dist]


print countDistStepsWays(3)
print countDistStepsWaysDp(3)
