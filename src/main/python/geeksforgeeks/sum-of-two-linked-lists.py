from math import fabs


class Node:
    def __init__(self, val):
        self.val = val
        self.next = None


carry, result, diffNode = 0, None, None


def getSizeOfList(head):
    if not head:
        return 0
    count = 0
    p = head
    while p:
        count += 1
        p = p.next
    return count


def pushBeforeHead(num, head):
    if not head:
        head = Node(num)
    else:
        new = Node(num)
        new.next = head
        head = new
    return head

def addSameSizeList(head1, head2):
    if not head2 or not head1:
        return
    global carry
    addSameSizeList(head1.next, head2.next)
    sum = carry + head1.val + head2.val
    carry = sum // 10
    global result
    result = pushBeforeHead(sum % 10, result)


def addDiffList(head, diffStart):
    if head == diffStart or not head:
        return
    global carry
    addDiffList(head.next, diffStart)
    sum = carry + head.val
    carry = sum / 10
    global result
    result = pushBeforeHead(sum % 10, result)


def addList():
    global head1, head2
    if not head1:
        return head2
    if not head2:
        return head1
    size1 = getSizeOfList(head1)
    size2 = getSizeOfList(head2)
    diff = fabs(size1 - size2)
    if diff == 0:
        addSameSizeList(head1, head2)
    else:
        if size1 < size2:
            head1, head2 = head2, head1
        global diffNode
        diffNode = head1
        while diff > 0:
            diffNode = diffNode.next
            diff -= 1
        addSameSizeList(diffNode, head2)
        addDiffList(head1, diffNode)
    if carry > 0:
        global result
        result = pushBeforeHead(carry, result)


arr1 = [9, 9, 9]
arr2 = [1, 8]
head1 = None;
head2 = None;
for i in reversed(arr1):
    head1 = pushBeforeHead(i, head1)
for j in reversed(arr2):
    head2 = pushBeforeHead(j, head2)

addList()

while result:
    print result.val,
    result = result.next
