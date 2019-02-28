# -*- coding: utf-8 -*-

# 建立大小为n的heap 以第i个元素为根
def build_max_heap(arr, n, i):

    l = i * 2 + 1
    r = i * 2 + 2

    largest = i

    if l < n and arr[largest] < arr[l]:
        largest = l

    if r < n and arr[largest] < arr[r]:
        largest = r

    if largest != i:
        arr[largest], arr[i] = arr[i], arr[largest]
        build_max_heap(arr, n, largest)


if __name__ == '__main__':

    arr = [4, 10, 3, 5, 1]

    n = len(arr)

    # from bottom up to build a heap
    for i in range(n, -1, -1):
        build_max_heap(arr, n, i)

    # extract elements from heap top

    for j in range(n - 1, 0, -1):
        arr[j], arr[0] = arr[0], arr[j]  # put heap top to last of the heap
        build_max_heap(arr, j, 0)

    for k in arr:
        print k,
