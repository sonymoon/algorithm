def subsetSum(arr, i, sum, n):
    if i < 0 or i >= n:
        return False

    if arr[i] == sum:
        return True

    if arr[i] > sum:
        return subsetSum(arr, i + 1, sum, n)

    if arr[i] <= sum:
        return subsetSum(arr, i + 1, sum - arr[i], n) or subsetSum(arr, i + 1, sum, n)


def main(arr, giveSum):
    n = len(arr)
    return subsetSum(arr, 0 , giveSum, n)


print main([3, 34, 4, 12, 5, 2], 33)