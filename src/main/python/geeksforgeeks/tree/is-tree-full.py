# -*- coding: utf-8 -*-

# A full binary tree is defined as a binary tree in which all nodes have either zero or two child nodes. Conversely,
# there is no node in a full binary tree, which has one child node.
# More information about full binary trees can be found here.

from Node import Node

def is_tree_full(root):

    if not root:
        return True

    if root.left and not root.right:
        return False
    if root.right and not root.left:
        return False
    if not root.left and not root.right:
        return True

    if root.left and root.right:  # two node
        return is_tree_full(root.left) and is_tree_full(root.right)


# Driver Program
root = Node(10);
root.left = Node(20);
root.right = Node(30);

root.left.right = Node(40);
root.left.left = Node(50);
root.right.left = Node(60);
root.right.right = Node(70);

root.left.left.left = Node(80);
root.left.left.right = Node(90);
root.left.right.left = Node(80);
root.left.right.right = Node(90);
root.right.left.left = Node(80);
root.right.left.right = Node(90);
root.right.right.left = Node(80);
root.right.right.right = Node(90);

if is_tree_full(root):
    print "The Binary tree is full"
else:
    print "Binary tree is not full"