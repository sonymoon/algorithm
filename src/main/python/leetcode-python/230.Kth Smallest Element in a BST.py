# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def kthSmallest(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: int
        """

        def inOrderTranverse(node, ans, k):

            if node.left:
                return inOrderTranverse(node.left, ans, k)

            if node:
                ans.append(node.val)
                print ans
                if len(ans) == k:
                    return ans[k - 1]

            if node.right:
                return inOrderTranverse(node.right, ans, k)

        ans = []
        return inOrderTranverse(root, ans, k)


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


def stringToInt(input):
    return int(input)


def intToString(input):
    if input is None:
        input = 0
    return str(input)


def main():
    import sys
    def readlines():
        for line in sys.stdin:
            yield line.strip('\n')

    lines = readlines()
    while True:
        try:
            line = lines.next()
            root = stringToTreeNode(line)
            line = lines.next()
            k = stringToInt(line)

            ret = Solution().kthSmallest(root, k)

            out = intToString(ret)
            print out
        except StopIteration:
            break


if __name__ == '__main__':
    main()