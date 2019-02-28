# -*- coding: utf-8 -*-
from Node import Node

res = float("-inf")


# 只有顶层root节点才可能即经过左边 又经过右边

def maxPathSum(root):
    if not root:
        return 0

    max_l = maxPathSum(root.left)
    max_r = maxPathSum(root.right)

    max_single = max(max(max_l, max_r) + root.data, root.data)

    max_top = max(max_single, max_l + max_r + root.data)
    global  res
    res = max(res, max_top)

    return max_single


# Driver program
root = Node(10)
root.left = Node(2)
root.right = Node(10);
root.left.left = Node(20);
root.left.right = Node(1);
root.right.right = Node(-25);
root.right.right.left = Node(3);
root.right.right.right = Node(4);

maxPathSum(root)
print res
