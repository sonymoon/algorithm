# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        path2p, path2q = [root], [root]
        while path2p[-1] is not p or path2q[-1] is not q:
            curp, curq = path2p[-1], path2q[-1]
            if curp == q:
                return curp
            if curq == p:
                return curq
            if curp != p and p.val < curp.val:
                path2p.append(curp.left)
            if curp != p and p.val > curp.val:
                path2p.append(curp.right)
            if curq != q and q.val < curq.val:
                path2q.append(curq.left)
            if q.val > curq.val:
                path2q.append(curq.right)

        i = 0
        while i < len(path2p) and i < len(path2q):
            if path2p[i] != path2q[i]:
                break
            i += 1
        return path2p[i - 1]
