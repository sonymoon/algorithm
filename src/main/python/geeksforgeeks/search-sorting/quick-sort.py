def partition(arr, low, high):
    pivot = arr[high]

    i = low
    for j in range(low, high):
        if arr[j] <= pivot:
            arr[i], arr[j] = arr[j], arr[i]
            i += 1

    arr[high], arr[i] = arr[i], arr[high]
    return i


def partition_first(arr, low, high):
    pivot = arr[low]
    i = high  # point to smaller one in the right part
    for j in range(high, low, -1):  # j point to the bigger than pivot one in the left part
        if arr[j] >= pivot:
            arr[j], arr[i] = arr[i], arr[j]
            i -= 1
    arr[low], arr[i] = arr[i], arr[low]
    return i


def quick_sort(arr, low, high):
    if low >= high:
        return

    pivot = partition_first(arr, low, high)

    quick_sort(arr, low, pivot - 1)
    quick_sort(arr, pivot + 1, high)


arr = [10, 80, 30, 90, 40, 50, 70]
if __name__ == "__main__":
    quick_sort(arr, 0, len(arr) - 1)
    for x in arr:
        print x,
