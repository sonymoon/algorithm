# -*- coding: utf-8 -*-


def next_great_number(arr):
    result = []
    n = len(arr)
    for i in range(n):
        stack = []  # 栈存储当前数组
        for j in range(i + 1, n):
            if arr[j] > arr[i]:
                stack.append(arr[j])
                break
        if not stack:
            result.append((arr[i], -1))
        else:
            result.append((arr[i], stack[0]))

    for x in result:
        print x,


arr = [4, 5, 2, 25]

print next_great_number(arr)
print next_great_number([13, 7, 6, 12])
