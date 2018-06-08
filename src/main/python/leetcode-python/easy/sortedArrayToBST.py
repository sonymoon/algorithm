# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def sortedArrayToBST(self, nums):
        """
        :type nums: List[int]
        :rtype: TreeNode
        """
        if not nums:
            return None

        def sortedArrayToBSTRecursive(nums, low, high):
            if low > high:
                return None
            mid = (low + high + 1) // 2
            node = TreeNode(nums[mid])
            node.left = sortedArrayToBSTRecursive(nums, low, mid - 1)
            node.right = sortedArrayToBSTRecursive(nums, mid + 1, high)
            return node

        return sortedArrayToBSTRecursive(nums, 0, len(nums) - 1)