# -*- coding:utf-8 -*-


class Graph:

    def __init__(self, vertices):
        self.V = vertices
        self.graph = []

    def addEdge(self, u, v, w):
        self.graph.append([u, v, w])


def find(parent, i):
    if parent[i] == i:
        return i
    else:
        return find(parent, parent[i])


def union(parent, rank, u, v):
    uroot = find(parent, u)
    vroot = find(parent, v)

    if rank[uroot] > rank[vroot]:
        parent[vroot] = uroot
    elif rank[uroot] < rank[vroot]:
        parent[uroot] = vroot
    else:
        parent[vroot] = uroot
        rank[uroot] += 1


def kruskal_mst(g):
    parent = [i for i in range(g.V)]
    rank = [0] * g.V
    result = []
    count, i = [0, 0]
    g.graph = sorted(g.graph, key=lambda node: node[2])
    while count < g.V - 1:
        u, v, w = g.graph[i]
        i += 1
        x = find(parent, u)
        y = find(parent, v)
        if x != y:
            count += 1
            result.append([u, v, w])
            union(parent, rank, u, v)

    print "the kruskal mst's edges are:"
    for node in result:
        u, v, w = node
        print u, "=>", v, "==", w


# Driver code
g = Graph(4)
g.addEdge(0, 1, 10)
g.addEdge(0, 2, 6)
g.addEdge(0, 3, 5)
g.addEdge(1, 3, 15)
g.addEdge(2, 3, 4)

kruskal_mst(g)
