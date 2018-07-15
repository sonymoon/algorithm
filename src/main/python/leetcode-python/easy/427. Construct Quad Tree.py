# Definition for a QuadTree node.
class Node:
    def __init__(self, val, isLeaf, topLeft, topRight, bottomLeft, bottomRight):
        self.val = val
        self.isLeaf = isLeaf
        self.topLeft = topLeft
        self.topRight = topRight
        self.bottomLeft = bottomLeft
        self.bottomRight = bottomRight


class Solution:

    def isleaf(self, grid, xstart, xend, ystart, yend):
        for i in range(xstart, xend + 1):
            for j in range(ystart, yend + 1):
                if grid[i][i] != grid[xstart][ystart]:
                    return False
        return True

    def construct(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: Node
        """

        def constructChild(grid, xstart, xend, ystart, yend):
            """
            :param grid: List[List[int]]
            :param xstart: int
            :param xend: int
            :param ystart: int
            :param yend: int
            :return: Node
            """
            if self.isleaf(grid, xstart, xend, ystart, yend):
                return Node(grid[xstart][ystart] == 1, True, None, None, None, None)
            else:
                node = Node(grid[xstart][ystart] == 1, False, None, None, None, None)
                node.topLeft = constructChild(grid, xstart, xstart + (xend - xstart) // 2, ystart,
                                              ystart + (yend - ystart) // 2)
                node.topRight = constructChild(grid, xstart + (xend - xstart) // 2 + 1, xend, ystart,
                                               ystart + (yend - ystart) // 2)
                node.bottomLeft = constructChild(grid, xstart, xstart + (xend - xstart) // 2,
                                                 ystart + (yend - ystart) // 2 + 1, yend)
                node.bottomRight = constructChild(grid, xstart + (xend - xstart) // 2 + 1, xend,
                                                  ystart + (yend - ystart) // 2 + 1, yend)

        length = len(grid)
        return constructChild(grid, 0, length - 1, 0, length - 1)
