# -*- coding: utf-8 -*-


class Graph:

    def __init__(self, vertices):
        self.V = vertices
        self.graph = [[] for i in range(vertices)]

    def addEdge(self, u, v):
        self.graph[u].append(v)

    def topological(self):
        visited = [False] * self.V
        stack = []

        for v in range(self.V):
            if not visited[v]:
                self.topologicalUtil(stack, visited, v)

        print stack

    def topologicalUtil(self, stack, visited, v):
        visited[v] = True
        for i in self.graph[v]:
            if not visited[i]:
                self.topologicalUtil(stack, visited, i)
        stack.insert(0, v)


g = Graph(6)
g.addEdge(5, 2);
g.addEdge(5, 4);
g.addEdge(4, 0);
g.addEdge(4, 1);
g.addEdge(2, 3);
g.addEdge(3, 1);

g.topological()
