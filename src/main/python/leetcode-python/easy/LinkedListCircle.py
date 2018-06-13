# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def hasCycle(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        if head == None:
            return False
        i = head
        if head.next == None:
            return False
        j = head.next.next
        while i or j:
            if i == j:
                return True
            i = i.next
            j = j.next
            if j != None:
                j = j.next
        return False
