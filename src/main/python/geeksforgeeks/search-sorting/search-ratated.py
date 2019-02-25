arr = [5, 6, 7, 8, 9, 10, 1, 2, 3]


def find_pivot(arr):
    n = len(arr)
    l = 0
    r = n - 1
    while l < r:
        mid = l + (r - l) // 2
        if mid < r and arr[mid] > arr[mid + 1]:
            return mid
        if mid > l and arr[mid - 1] > arr[mid]:
            return mid - 1
        if arr[l] < arr[mid]:  # ascending order, so pivot maybe in high sub
            l = mid + 1
        elif arr[l] >= arr[mid]:
            r = mid - 1

    return -1


def search(arr, param, l, r):
    if r < l:
        return -1
    middle = l + (r - l) // 2
    if param == arr[middle]:
        return middle

    elif param < arr[middle]:
        return search(arr, param, l, middle - 1)
    else:
        return search(arr, param, middle + 1, r)


pivot = find_pivot(arr)
x = 1
if pivot != -1 and arr[0] > x:
    print search(arr, x, pivot + 1, len(arr) - 1)
else:
    print search(arr, x, 0, pivot)
