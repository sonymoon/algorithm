# code {50, 3, 10, 7, 40, 80}
def _lis_recur(arr, n):
    if n == 1:
        return 1
    maxN = 1
    for i in range(1, n):
        res = _lis_recur(arr, i)
        if arr[i - 1] < arr[n - 1] and res + 1 > maxN:
            maxN = res + 1
    return maxN


def lis_recur(arr):
    n = len(arr)
    if n == 0:
        return 0
    return _lis_recur(arr, n)


def lis_mem(arr):
    n = len(arr)
    if n == 0 or n == 1:
        return n
    lis = [1] * n
    for i in range(1, n):
        for j in range(0, i):
            if arr[j] < arr[i] and lis[i] < lis[j] + 1:
                lis[i] = lis[j] + 1
    return max(lis)


arr = [10, 22, 9, 33, 21, 50, 41, 60]
n = len(arr)
print "Length of lis is ", lis_mem(arr)
