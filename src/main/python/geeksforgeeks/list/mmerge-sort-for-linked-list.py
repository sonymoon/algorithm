# key point is to find the half node

class Node:
    def __init__(self, val):
        self.val = val
        self.next = None


class LinkList:
    def __init__(self):
        self.head = None

    def push(self, val):
        node = Node(val)
        if self.head:
            node.next = self.head
            self.head = node
        else:
            self.head = node

    def printList(self):
        p = self.head
        while p:
            print p.val,
            p = p.next
        print


def mergeSort(head):
    if not head:
        return
    if not head.next:
        return

    slow = head
    fast = head.next
    while fast:
        fast = fast.next
        if fast:
            slow = slow.next
            fast = fast.next
    # 2 3 20 5 10 15
    frontHalf = head
    backHalf = slow.next
    slow.next = None
    mergeSort(frontHalf)
    mergeSort(backHalf)
    head = sortedMerge(frontHalf, backHalf)
    return head


def sortedMerge(a, b):
    if not a:
        return b
    elif not b:
        return a
    temp = None
    if a.val <= b.val:
        temp = a
        a.next = sortedMerge(temp.next, b)
        return a
    else:
        temp = b
        b.next = sortedMerge(a, temp.next)
        return b


ll = LinkList()
ll.push(15)
ll.push(10)
ll.push(5)
ll.push(20)
ll.push(3)
ll.push(2)

ll.printList()

ll.head = mergeSort(ll.head)

ll.printList()
