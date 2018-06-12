# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution(object):
    def getIntersectionNode(self, head1, head2):
        """
        :type head1, head2: ListNode
        :rtype: ListNode
        """
        if None in (head1, head2):
            return None
        p1 = head1
        p2 = head2
        if p1 == p2:
            return head1

        tail1 = None
        tail2 = None
        while p1:
            tail1 = p1
            p1 = p1.next
        while p2:
            tail2 = p2
            p2 = p2.next
        if tail1 and tail2 and tail1 == tail2:
            return tail1
        if tail1 and tail2 and tail1 != tail2:
            return None
        p1 = head1
        p2 = head2
        while p1.val != p2.val:
            if p1.next == None:
                p1.next = head2
            if p2.next == None:
                p2.next = head1
            p1 = p1.next
            p2 = p2.next
        tail1.next = None
        tail2.next = None
        return p1
