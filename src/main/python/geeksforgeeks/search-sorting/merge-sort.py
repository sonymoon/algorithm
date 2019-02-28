# -*- coding: utf-8 -*-

def merge(arr, l, mid, r):
    p1 = 0
    p2 = 0
    i = l
    left = arr[l:mid + 1]
    right = arr[mid + 1:r + 1]

    while p1 < len(left) and p2 < len(right):
        if left[p1] <= right[p2]:
            arr[i] = left[p1]
            p1 += 1
        else:
            arr[i] = right[p2]
            p2 += 1
        i += 1

    while p1 < len(left):
        arr[i] = left[p1]
        p1 += 1
        i += 1
    while p2 < len(right):
        arr[i] = right[p2]
        p2 += 1
        i += 1


def _merge_sort(arr, l, r):
    if l >= r:
        return

    mid = (l + r) // 2

    _merge_sort(arr, l, mid)
    _merge_sort(arr, mid + 1, r)

    merge(arr, l, mid, r)


if __name__ == '__main__':
    arr = [12, 11, 13, 5, 6, 7]
    _merge_sort(arr, 0, len(arr) - 1)
    for x in arr:
        print x,
