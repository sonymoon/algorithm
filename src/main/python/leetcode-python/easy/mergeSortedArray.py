class Solution:
    def merge(self, nums1, m, nums2, n):
        """
        :type nums1: List[int]
        :type m: int
        :type nums2: List[int]
        :type n: int
        :rtype: void Do not return anything, modify nums1 in-place instead.
        """
        n1, n2 = m - 1, n - 1
        length = len(nums1)
        for i in range(m + n):
            if n1 == -1:
                nums1[-i-1] = nums2[n2]
                n2 -= 1
                continue
            if n2 == -1:
                nums1[-i-1] = nums1[n1]
                n1 -= 1
                continue
            if n1 == -1 and n2 == -1:
                return

            if nums1[n1] <= nums2[n2]:
                nums1[-i-1] = nums2[n2]
                n2 -= 1
            elif nums1[n1] > nums2[n2]:
                nums1[-i-1] = nums1[n1]
                n1 -= 1


import json


def stringToIntegerList(input):
    return json.loads(input)


def integerListToString(nums, len_of_list=None):
    if not len_of_list:
        len_of_list = len(nums)
    return json.dumps(nums[:len_of_list])


def main():
    import sys

    def readlines():
        for line in sys.stdin:
            yield line.strip('\n')

    lines = readlines()
    while True:
        try:
            line = next(lines)
            nums1 = stringToIntegerList(line)
            line = next(lines)
            m = int(line)
            line = next(lines)
            nums2 = stringToIntegerList(line)
            line = next(lines)
            n = int(line)

            ret = Solution().merge(nums1, m, nums2, n)

            out = integerListToString(nums1)
            if ret is not None:
                print("Do not return anything, modify nums1 in-place instead.")
            else:
                print(out)
        except StopIteration:
            break


if __name__ == '__main__':
    main()
