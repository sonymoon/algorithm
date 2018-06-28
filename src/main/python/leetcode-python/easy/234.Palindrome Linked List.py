# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def isPalindrome(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        length = 0
        p = head
        while p:  # calc lengh
            length += 1
            p = p.next
        if length in [0, 1]:
            return True

        firstHalf = length // 2  # find half node
        p = head
        while firstHalf > 1:
            p = p.next
            firstHalf -= 1

        q = p.next if length % 2 == 0 else p.next.next  # left half head
        pre, half = None, p.next
        while head != half:  # reverse firstHalf
            _next = head.next
            head.next, pre, head = pre, head, _next

        while p and q:
            if p.val != q.val:
                return False
            p, q = p.next, q.next
        return True

def stringToIntegerList(input):
    import json
    return json.loads(input)


def stringToListNode(input):
    # Generate list from the input
    numbers = stringToIntegerList(input)

    # Now convert that list into linked list
    dummyRoot = ListNode(0)
    ptr = dummyRoot
    for number in numbers:
        ptr.next = ListNode(number)
        ptr = ptr.next

    ptr = dummyRoot.next
    return ptr


def main():
    import sys

    def readlines():
        for line in sys.stdin:
            yield line.strip('\n')

    lines = readlines()
    while True:
        try:
            line = next(lines)
            head = stringToListNode(line)

            ret = Solution().isPalindrome(head)

            out = (ret)
            print(out)
        except StopIteration:
            break


if __name__ == '__main__':
    main()
