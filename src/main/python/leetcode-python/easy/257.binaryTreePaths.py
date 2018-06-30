# Definition for a binary tree node.

import collections


class TreeNode:

    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:

    def binaryTreePaths(self, root):
        """
        :type root: TreeNode
        :rtype: List[str]
        """
        if not root:
            return []
        paths, nodes = [], [(root, "")]
        while nodes:
            cur, path = nodes.pop()
            if not cur.left and not cur.right:
                paths.append(path + str(cur.val))
            if cur.left:
                nodes.append((cur.left, path + str(cur.val) + "->"))
            if cur.right:
                nodes.append((cur.right, path + str(cur.val) + "->"))
        return paths

    # use queue
    def binaryTreePaths(self, root):
        if not root:
            return []
        paths, queue = [], collections.deque([(root, "")])
        while queue:
            node, path = queue.popleft()
            if not node.left and not node.right:
                paths.append(path + str(node.val))
            if node.left:
                queue.append((node.left, path + str(node.val) + "->"))
            if node.right:
                queue.append((node.right, path + str(node.val) + "->"))
        return paths