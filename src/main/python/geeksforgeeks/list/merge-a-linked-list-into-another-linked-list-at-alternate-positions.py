class Node:
    def __init__(self, val):
        self.val = val
        self.next = None


class Solution:
    def __init__(self, head1, head2):
        self.head1 = head1
        self.head2 = head2

    def mergeLists(self):
        if not self.head1:
            return

        p1 = self.head1
        p2 = self.head2
        while p1 and p2:
            p2_next = p2.next
            p1_next = p1.next

            p1.next = p2
            p2.next = p1_next

            p2 = p2_next
            p1 = p1_next

        self.head2 = p2

    def printStr(self):
        if self.head1:
            p = self.head1
            print "head1: ",
            while p:
                print p.val,
                p = p.next
            print ''
        if self.head2:
            p = self.head2
            print "head2: ",
            while p:
                print p.val,
                p = p.next
            print ''


def pushBeforeHead(num, head):
    if not head:
        head = Node(num)
    else:
        new = Node(num)
        new.next = head
        head = new
    return head


arr1 = [1, 2, 3]
arr2 = [12, 10, 2, 4, 6]
head1, head2 = None, None
for i in reversed(arr1):
    head1 = pushBeforeHead(i, head1)
for j in reversed(arr2):
    head2 = pushBeforeHead(j, head2)
s = Solution(head1, head2)
s.mergeLists()
s.printStr()
