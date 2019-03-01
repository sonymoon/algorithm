# -*- coding: utf-8 -*-

# o(n^2)
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


# o(n^2)
# 1 一个stack，保存的是比后面元素大的值，因为还没找到比自己大的。 初始保存第一个元素
# 2 从第二个元素，如果stack中的元素比其小，那么就找到了next greater one. 循环一直到元素为空
# 3 如果stack弹出比其大，那么这个元素需要进栈，再次执行2
def next_great_number_2(arr):
    n = len(arr)

    stack = [arr[0]]
    for i in range(1, n):
        if stack:
            next = arr[i]
            element = stack.pop()
            while element < next:
                print element, '->', next
                if stack:
                    element = stack.pop()
                else:
                    break
        if element > next:
            stack.append(element)
        stack.append(next)

    while stack:
        print stack.pop(0), '->', -1

next_great_number_2([11, 13, 21, 3])
