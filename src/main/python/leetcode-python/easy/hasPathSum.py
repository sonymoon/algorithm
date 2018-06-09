# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    def hasPathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: bool
        """
        if root == None:
            return False
        sum -= root.val
        if sum == 0 and root.left == None and root.right == None:
            return True
        leftHas = self.hasPathSum(root.left, sum)
        rightHas = self.hasPathSum(root.right, sum)
        return leftHas or rightHas
