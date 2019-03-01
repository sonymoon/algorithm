# coding=utf-8

# Given an array of numbers, return true if given array can
# represent preorder traversal of a Binary Search Tree, else return false. Expected time complexity is O(n).


# Input:  pre[] = {2, 4, 3}
# Output: true
# Given array can represent preorder traversal
# of below tree
#     2
#
#       4
#      /
#     3
#
# Input:  pre[] = {2, 4, 1}
# Output: false
# Given array cannot represent preorder traversal
# of a Binary Search Tree.
#
# Input:  pre[] = {40, 30, 35, 80, 100}
# Output: true
# Given array can represent preorder traversal
# of below tree
#      40
#    /
#  30    80
#
#   35     100
#
#
# Input:  pre[] = {40, 30, 35, 20, 80, 100}
# Output: false
# Given array cannot represent preorder traversal
# of a Binary Search Tree.


# Algorithm Preorder(tree)
#    1. Visit the root.
#    2. Traverse the left subtree, i.e., call Preorder(left-subtree)
#    3. Traverse the right subtree, i.e., call Preorder(right-subtree)

# root > left, root < right


# 判断i..j之间是不是前序遍历。包含j
# O(n^2)
def is_preorder(pre, l, r):

    if l >= r:
        return True

    for i in range(l, r + 1):
        firstLargerOne = i
        for j in range(i + 1, r + 1):
            # 找到第一个大于当前i节点的
            if pre[j] > pre[i]:
                firstLargerOne = j
                break
        # 剩下的节点如果都比i大，则剩下的节点都在右子树，否则不是前序遍历
        for k in range(firstLargerOne + 1, r + 1):
            if pre[k] < pre[i]:
                return False
        return is_preorder(pre, l + 1, firstLargerOne - 1) and is_preorder(pre, firstLargerOne + 1, r)


pre = [40, 30, 35, 20, 80, 100]

print is_preorder(pre, 0, len(pre) - 1)
