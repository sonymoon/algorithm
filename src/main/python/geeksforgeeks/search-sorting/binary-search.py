arr = [2, 3, 4, 10, 40]


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


# search 5
# search 2,n = 5
# search 2 + 1 = 3
# search 3, n = 5
# search

def binarySearch(arr, param):
    n = len(arr)
    return search(arr, param, 0, n - 1)


print binarySearch(arr, 5)


def binarySearch_iterative(arr, x):
    l = len(arr)

    r = l - 1  # include
    l = 0

    while l < r:
        mid = l + (r -l) // 2
        if arr[mid] == x:
            return mid
        elif arr[mid] < x:
            r = mid - 1
        else:
            l = mid + 1
    return -1


print binarySearch_iterative(arr, 5)
