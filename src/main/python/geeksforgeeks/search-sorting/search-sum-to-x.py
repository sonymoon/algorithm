def quick_sort(arr, l, r):
    if l >= r:
        return
    i = partition(arr, l, r)
    quick_sort(arr, l, i - 1)
    quick_sort(arr, i + 1, r)


def partition(arr, l, r):
    pivot = arr[r]
    i = l
    for j in range(l, r):
        if arr[j] <= pivot:
            arr[j], arr[i] = arr[i], arr[j]
            i += 1

    arr[i], arr[r] = arr[r], arr[i]
    return i


def find_pair_closest(arr, sum):
    n = len(arr)
    quick_sort(arr, 0, n - 1)
    dic = {}
    for i in range(n // 2 + 1):
        left = sum - arr[i]
        if left > 0:
            # find the first one that less or equal than left
            for j in range(n - 1, -1, -1):
                if arr[j] <= left and j != i:
                    dic[arr[i]] = arr[j]
                    break

    closest_key = -1
    closest_sum = 0
    for k, v in dic.items():
        if k + v > closest_sum:
            closest_sum = k + v
            closest_key = k
    if closest_key in dic:
        return [closest_key, dic[closest_key]]
    else:
        return []


arr = [10, 22, 28, 29, 30, 40]

print find_pair_closest(arr, 50)
