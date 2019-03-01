# -*- coding: utf-8 -*-


# Given a Binary Tree, we need to print the bottom view from left to right.
# A node x is there in output if x is the bottommost node at its horizontal distance.
# Horizontal distance of left child of a node x is equal to horizontal distance of x minus 1,
# and that of right child is horizontal distance of x plus 1.

from Node import Node


def printBottom(root):
    if not root:
        return

    dic = {}
    e = None
    q = [(root, 0)]
    while q:
        e = q.pop(0)

        node, dist = e

        dic[dist] = node

        if node.left:
            q.append((node.left, dist - 1))
        if node.right:
            q.append((node.right, dist + 1))

    for k in sorted(dic.keys(), cmp = lambda i, j: j - i):
        print dic[k].data,


root = Node(20)
root.left = Node(8)
root.right = Node(22)
root.left.left = Node(5)
root.left.right = Node(3)
root.right.left = Node(4)
root.right.right = Node(25)
root.left.right.left = Node(10)
root.left.right.right = Node(14)

printBottom(root)
