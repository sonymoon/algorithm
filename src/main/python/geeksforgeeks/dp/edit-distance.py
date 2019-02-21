# recursive method
def _ed(str1, str2, m, n):
    # If first string is empty, the only option is to
    # insert all characters of second string into first
    if m == -1:
        return n + 1
    # If second string is empty, the only option is to
    # remove all characters of first string
    if n == -1:
        return m + 1

    if str1[m] == str2[n]:
        return _ed(str1, str2, m - 1, n - 1)

    insert = _ed(str1, str2, m, n - 1)
    remove = _ed(str1, str2, m - 1, n)
    replace = _ed(str1, str2, m - 1, n - 1)
    # here we have operation one time
    return 1 + min(insert, remove, replace)


# dp method
# arr[i][j] represents str1(0...i) & str2(0...j) 's ed
def _ed2(str1, str2):
    m = len(str1)
    n = len(str2)

    arr = [[0] * (n + 1) for i in range(m + 1)]

    # Fill d[][] in bottom up manner
    for i in range(m + 1):
        for j in range(n + 1):
            if i == 0:
                arr[i][j] = j  # Min. operations = j
            elif j == 0:
                arr[i][j] = i
            elif str1[i - 1] == str2[j - 1]:
                arr[i][j] == arr[i - 1][j - 1]
            else:
                arr[i][j] = 1 + min(arr[i][j - 1], arr[i - 1][j], arr[i - 1][j - 1])

    return arr[m][n]


def ed2(arr, str1, str2, m, n):
    if m == -1:
        return
    if n == -1:
        return

    if str1[m] == str2[n]:
        arr[m][n] = _ed(str1, str2, m - 1, n - 1)


# Driver program to test the above function
str1 = "sunday"
str2 = "saturday"
print _ed(str1, str2, len(str1) - 1, len(str2) - 1)
print _ed2(str1, str2)
