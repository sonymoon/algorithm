import json


class Solution:
    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0

        j = len(nums) - 1
        i = 0
        while i < j:
            if nums[i] == val and nums[j] != val:
                nums[i], nums[j] = nums[j], nums[i]
                i += 1
                j -= 1
            elif nums[i] != val:
                i += 1
            elif nums[j] == val:
                j -= 1
        return j if nums[j] == val else j+1


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
            nums = stringToIntegerList(line)
            line = next(lines)
            val = int(line)

            ret = Solution().removeElement(nums, val)

            out = integerListToString(nums, len_of_list=ret)
            print(out)
        except StopIteration:
            break


if __name__ == '__main__':
    main()
