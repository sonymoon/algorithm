arr = [12, 11, 13, 5, 6]


def insertionSort(arr):
    n = len(arr)
    for i in range(1, n):
        temp = arr[i]
        j = i - 1
        while arr[j] > temp and j >= 0:
            arr[j + 1] = arr[j]
            j -= 1
        arr[j + 1] = temp


insertionSort(arr)
for x in arr:
    print x,
