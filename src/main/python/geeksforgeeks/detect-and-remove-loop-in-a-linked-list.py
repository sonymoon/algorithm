class Node:
    def __init__(self, data):
        self.data = data
        self.next = None


class LinkedList:
    def __init__(self):
        self.head = None

    def detectAndRemoveLoop(self):
        slow = self.head
        fast = self.head
        hasCircle = False
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            if slow == fast:
                hasCircle = True
                break

        if not hasCircle:
            return hasCircle

        slow = self.head
        last = None
        while slow != fast:
            last = fast
            slow, fast = slow.next, fast.next
        print "loop node is", fast.data
        last.next = None

        # Utility function to prit the linked LinkedList

    def detectAndRemoveLoopWithStorage(self):
        store = []
        p = self.head
        last = None
        while p:
            if p not in store:
                store.append(p)
                last = p
                p = p.next
            else:
                print "loop node is", p.data
                last.next = None
                return True
        return False

    def printList(self):
        temp = self.head
        while (temp):
            print temp.data,
            temp = temp.next


llist = LinkedList()
llist.head = Node(1)
llist.head.next = Node(2)
llist.head.next.next = Node(3)
llist.head.next.next.next = Node(4)
llist.head.next.next.next.next = Node(5)
llist.head.next.next.next.next.next = llist.head.next.next

llist.detectAndRemoveLoopWithStorage()

print "Linked List after removing loop"
llist.printList()