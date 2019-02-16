class Node:
    def __init__(self, c):
        self.c = c
        self.next = None

def compare(list1, list2):
    p1, p2 = list1, list2
    while p1 and p2 and p1.c == p2.c:
        p1, p2 = p1.next, p2.next
    if p1 and p2:
        return 1 if p1.c > p2.c else -1
    if p1 and not p2:
        return 1
    if p2 and not p1:
        return -1
    return 0


# Driver program

list1 = Node('g')
list1.next = Node('e')
list1.next.next = Node('e')
list1.next.next.next = Node('k')
list1.next.next.next.next = Node('s')
list1.next.next.next.next.next = Node('a')

list2 = Node('g')
list2.next = Node('e')
list2.next.next = Node('e')
list2.next.next.next = Node('k')
list2.next.next.next.next = Node('a')
list2.next.next.next.next.next = Node('b')

print compare(list1, list2)


