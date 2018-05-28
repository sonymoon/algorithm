# Definition for singly-linked list.
# 142+465=607


# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution:
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        carry = 0
        resultHead = c = ListNode(0)
        while l1 or l2 or carry > 0:
            num1 = l1.val if l1 else 0
            num2 = l2.val if l2 else 0
            carry = (num1 + num2 + carry)
            c.next = ListNode(carry % 10)
            carry = carry // 10
            c = c.next
            l1 = l1.next if l1 else None
            l2 = l2.next if l2 else None
        return resultHead.next
