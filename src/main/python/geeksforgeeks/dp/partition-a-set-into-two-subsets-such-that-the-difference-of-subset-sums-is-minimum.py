# coding:utf-8

def _minSubSetSum(arr, i, sumCurrent, sum):
    if i == 0:
        return abs(sum - 2 * sumCurrent)

    if arr[i - 1] <= sum - sumCurrent:
        return min(_minSubSetSum(arr, i - 1, sumCurrent + arr[i - 1], sum),  # include i - 1
                   _minSubSetSum(arr, i - 1, sumCurrent, sum))  # exclude i - 1


def minSubSetSum(arr):
    if not arr:
        return 0
    sumTotal = 0
    for i in arr:
        sumTotal += i
    return _minSubSetSum(arr, len(arr), 0, sumTotal)


# dp[n+1][sum + 1] to store 1 如果0..i-1 has a sum equal to j, else 0...i-1 has not a sum to j
# dp[i][j] 表示arr[0...i-1]的和是j, 不包含元素i-1的集合有和=j 或者包含元素i-1的集合有 和= sum/2 - j
# dp[i][j]递推式：dp[i][j] = dp[i-1][j] or dp[i-1][sum/2-j]

# result = min(sum - 2 * j且dp[n][j]) ==1,  j varies from 0...sum //2
# 如果其中一份集合的和是j，剩下的一份的和就是sum-j, 并且如果dp[0...n][j]有一个==1，则minSumDiff == sum - 2 * j

def dpSubSetSum(arr):
    sum = 0
    for x in arr:
        sum += x
    n = len(arr)

    # bottom up data for calculate
    dp = [[False] * (sum + 1) for i in range(n + 1)]

    i = 0
    for i in range(n + 1):
        dp[i][0] = True  # 0和对于所有arr[0...i]都可以完成分割
    for j in range(1, sum + 1):
        dp[0][j] = False

    for i in range(n + 1):
        for j in range(sum + 1):
            dp[i][j] = dp[i - 1][j]  # 如果0...i-1有和j，那么即使不要元素i, 0..i之间肯定有和j
            # 如果0...i有和j是因为i的参与，那么只要0...i-1有和j-arr[i]也行
            if arr[i-1] <= j:
                dp[i][j] = dp[i - 1][j - arr[i-1]]

    diff = sum

    j = 0
    for j in range(sum // 2, -1, -1):
        if dp[n][j] == True:
            diff = sum - 2 * j
            break
    return diff


arr = [1, 6, 11, 5]

print dpSubSetSum(arr)
