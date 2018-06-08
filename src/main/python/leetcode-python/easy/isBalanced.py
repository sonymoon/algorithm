# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    def isBalanced(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        def nodeHigh(node):
            if not node:
                return 0
            left = nodeHigh(node.left)
            if left == -1:
                return -1
            right = nodeHigh(node.right)
            if right == -1:
                return -1
            if abs(left - right) > 1:
                return -1
            return max(left, right) + 1
        return nodeHigh(root) != -1
