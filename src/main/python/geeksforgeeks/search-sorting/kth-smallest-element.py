# -*- coding: utf-8 -*-


def partition(arr, l, r):
    if l > r:
        return
    pivot = arr[r]

    i, j = l, l

    while i <= r - 1 and j <= r - 1:

        if arr[j] < pivot:
            arr[i], arr[j] = arr[j], arr[i]
            i += 1
        j += 1
    arr[i], arr[j] = arr[j], arr[i]
    return i


def find_kth_smallest(arr, k, l, r):
    if l > r or k <= 0:
        return None

    p = partition(arr, l, r)

    if p - l == k - 1:
        return arr[p]
    elif p - l > k - 1:  # 则第k小的在左边
        return find_kth_smallest(arr, k, l, p - 1)
    else:
        # 比如找l=0 r = 3 p =2 那么0.1.2都是比第k小元素小的 故(p-l) + 1
        return find_kth_smallest(arr, k - (p - l + 1), p + 1, r)


if __name__ == "__main__":
    arr = [7, 10, 4, 3, 20, 15]
    k = 4
    print find_kth_smallest(arr, k, 0, len(arr) - 1)
