# -*- coding: utf-8 -*-


class SubSet:

    def __init__(self, u, rank):
        self.parent = u
        self.rank = rank


# 使用邻接表
class Graph:

    def __init__(self, vertices):
        self.V = vertices
        self.edges = [[] for i in range(vertices)]

    def add_edge(self, u, v):
        self.edges[u].append(v)


def find(subsets, node):
    if subsets[node].parent != node:
        subsets[node].parent = find(subsets, subsets[node].parent)
    return subsets[node].parent


def union(subsets, u, v):
    if subsets[u].rank > subsets[v].rank:
        subsets[v].parent = u
    elif subsets[u].rank < subsets[v].rank:
        subsets[u].parent = v
    else:
        subsets[v].parent = u
        subsets[u].rank += 1


def is_cycle(g):
    subsets = [SubSet(u, 0) for u in range(g.V)]
    for i in range(g.V):
        i_parent = find(subsets, i)
        for j in g.edges[i]:
            j_parent = find(subsets, j)
            if subsets[i_parent] == subsets[j_parent]:
                return True
            else:
                union(subsets, i_parent, j_parent)
    return False


# Driver Code
g = Graph(3)

# add edge 0-1
g.add_edge(0, 1)

# add edge 1-2
g.add_edge(1, 2)

# add edge 0-2
g.add_edge(0, 2)

if is_cycle(g):
    print('Graph contains cycle')
else:
    print('Graph does not contain cycle')

# This code is contributed by
# Sampath Kumar Surine
