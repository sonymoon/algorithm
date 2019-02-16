class LinkNode:

    def __init__(self, data):
        self.data = data
        self.next = None


class SortedLinkList:

    def __init__(self):
        self.head = None

    def insert(self, new_node):
        if self.head is None:
            self.head = new_node
        elif self.head.data >= new_node.data:
            new_node.next = self.head
            self.head = new_node
        else:
            current = self.head
            while current.next is not None and current.next.data < new_node.data:
                current = current.next
            new_node.next = current.next
            current.next = new_node

    def printList(self):
        current = self.head
        while current is not None:
            print current.data,
            current = current.next


llist = SortedLinkList()
llist.insert(LinkNode(5))
llist.insert(LinkNode(10))
llist.insert(LinkNode(7))
llist.insert(LinkNode(3))
llist.insert(LinkNode(1))
llist.insert(LinkNode(9))

llist.printList()
