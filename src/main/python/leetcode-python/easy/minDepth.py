# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    def minDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        def mindepthOf(node, depth):
            if not node:
                return depth - 1
            if node.left == None and node.right == None:
                return depth
            if node.left == None:
                return mindepthOf(node.right, depth + 1)
            if node.right == None:
                return mindepthOf(node.left, depth + 1)

            left = mindepthOf(node.left, depth + 1)
            right = mindepthOf(node.right, depth + 1)
            return min(left, right)
        return mindepthOf(root, 1)
