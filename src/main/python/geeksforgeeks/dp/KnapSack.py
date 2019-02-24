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
