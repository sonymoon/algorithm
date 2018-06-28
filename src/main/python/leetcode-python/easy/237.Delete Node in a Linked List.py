# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def deleteNode(self, node):
        """
        :type node: ListNode
        :rtype: void Do not return anything, modify node in-place instead.
        """
        pre, _next = node, node.next
        while _next.next:
            pre.val = _next.val
            pre = pre.next
            _next = _next.next
        # tail
        pre.val = _next.val
        pre.next = None
