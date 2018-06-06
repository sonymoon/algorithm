# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


from collections import deque
class Solution:

    from collections import deque

    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        q = deque([])
        q.append(root)
        q.append(root)
        while q:
            node1 = q.popleft()
            node2 = q.popleft()
            if node1 == None and node2 == None:
                continue
            if None in (node1, node2):
                return False
            if node1.val != node2.val:
                return False
            q.append(node1.left)
            q.append(node2.right)
            q.append(node1.right)
            q.append(node2.left)
        return True


def stringToTreeNode(input):
    input = input.strip()
    input = input[1:-1]
    if not input:
        return None

    inputValues = [s.strip() for s in input.split(',')]
    root = TreeNode(int(inputValues[0]))
    nodeQueue = [root]
    front = 0
    index = 1
    while index < len(inputValues):
        node = nodeQueue[front]
        front = front + 1

        item = inputValues[index]
        index = index + 1
        if item != "null":
            leftNumber = int(item)
            node.left = TreeNode(leftNumber)
            nodeQueue.append(node.left)

        if index >= len(inputValues):
            break

        item = inputValues[index]
        index = index + 1
        if item != "null":
            rightNumber = int(item)
            node.right = TreeNode(rightNumber)
            nodeQueue.append(node.right)
    return root


def main():
    import sys

    def readlines():
        for line in sys.stdin:
            yield line.strip('\n')

    lines = readlines()
    while True:
        try:
            line = next(lines)
            root = stringToTreeNode(line)

            ret = Solution().isSymmetric(root)

            out = (ret)
            print(out)
        except StopIteration:
            break


if __name__ == '__main__':
    main()
