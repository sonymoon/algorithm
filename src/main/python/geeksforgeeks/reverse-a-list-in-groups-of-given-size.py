class Node:
    def __init__(self, val):
        self.val = val
        self.next = None


class Solution:
    def __init__(self):
        self.head = None

    def reverseList(self, head, k):
        curr = head
        pre = None # do not assign value, or it will cost one time of k
        next = None
        count = 0
        while count < k and curr:
            next = curr.next # always store before assign
            curr.next = pre

            pre = curr
            curr = next

            count += 1
        if next: # the whole point, head.next make k+1's last node to origin k's first node
             head.next = self.reverseList(next, k)
        return pre

    # Function to insert a new node at the beginning
    def push(self, new_data):
        if self.head:
            new_node = Node(new_data)
            new_node.next = self.head
            self.head = new_node
        else:
            self.head = Node(new_data)
        # Utility function to print the linked LinkedList

    def printList(self):
        temp = self.head
        while (temp):
            print temp.val,
            temp = temp.next


# Driver program
solution = Solution()
solution.push(9)
solution.push(8)
solution.push(7)
solution.push(6)
solution.push(5)
solution.push(4)
solution.push(3)
solution.push(2)
solution.push(1)

print "Given linked list"
solution.printList()
solution.head = solution.reverseList(solution.head, 3)

print "\nReversed Linked list"
solution.printList()
