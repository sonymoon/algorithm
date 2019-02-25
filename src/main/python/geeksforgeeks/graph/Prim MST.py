# -*- coding: utf-8 -*-
from sys import maxint


# 使用带权重的邻接矩阵表示图
class Graph:

    def __init__(self, vertices):
        self.V = vertices
        self.graph = [[0 for i in range(vertices)] for j in range(vertices)]

    def prim_mst(self):
        key = [maxint] * self.V
        mst_tree = [False] * self.V
        key[0] = 0

        parent = [None] * self.V

        # 遍历顶点
        for i in range(self.V):
            u = self.min_vertex(key, mst_tree)
            mst_tree[u] = True
            # 遍历u的邻接点
            for v in range(self.V):
                if 0 < self.graph[u][v] < key[v] and mst_tree[v] is False:
                    key[v] = self.graph[u][v]
                    parent[v] = u

        self.print_mst(parent)

    def min_vertex(self, key, mst_tree):
        min_value = maxint
        min_vertex = 0
        for v in range(self.V):
            if key[v] < min_value and mst_tree[v] is False:
                min_value = key[v]
                min_vertex = v
        return min_vertex

    def print_mst(self, parent):
        for v in range(1, self.V):
            print parent[v], "->", v, " weight= ", self.graph[parent[v]][v]


g = Graph(5)
g.graph = [[0, 2, 0, 6, 0],
           [2, 0, 3, 8, 5],
           [0, 3, 0, 0, 7],
           [6, 8, 0, 0, 9],
           [0, 5, 7, 9, 0]]
g.prim_mst();
