from Node import Node

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
        print ""