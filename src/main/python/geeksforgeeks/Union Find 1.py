from collections import defaultdict


class Graph:

    def __init__(self, vertices):
        self.V = vertices
        self.graph = defaultdict(list)  # default dictionary to store graph

    def add_edge(self, u, v):
        self.graph[u].append(v)

    def find_parent(self, parent, i):
        if parent[i] == - 1:
            return i
        if parent[i] != -1:
            return self.find_parent(parent, parent[i])

    def union(self, parent, x, y):
        x_set = self.find_parent(parent, x)
        y_set = self.find_parent(parent, y)
        parent[x_set] = y_set

    def is_cycle(self):
        parent = [-1] * self.V
        for i in self.graph:
            for j in self.graph[i]:
                x = self.find_parent(parent, i)
                y = self.find_parent(parent, j)
                if x == y:
                    return True
                self.union(parent, x, y)
        return False


# Create a graph given in the above diagram
g = Graph(3)
g.add_edge(0, 1)
g.add_edge(1, 2)
g.add_edge(2, 0)

if g.is_cycle():
    print "Graph contains cycle"
else:
    print "Graph does not contain cycle "

# This code is contributed by Neelam Yadav