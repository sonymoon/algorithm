from collections import defaultdict


class Graph:

    # Constructor
    def __init__(self):
        self.graph = defaultdict(list)

    def addEdge(self, u, v):
        self.graph[u].append(v)

    def BFS(self):
        visited = [False] * (max(self.graph.keys()) + 1)
        queue = []
        for u in self.graph.keys():
            if not visited[u]:
                queue.append(u)
            while queue:
                s = queue.pop(0)
                print(s, end=" ")
                for i in self.graph[s]:
                    if not visited[i]:
                        queue.append(i)
                        visited[i] = True


# Driver code

# Create a graph given in
# the above diagram
g = Graph()
g.addEdge(0, 1)
g.addEdge(0, 2)
g.addEdge(1, 2)
g.addEdge(2, 0)
g.addEdge(2, 3)
g.addEdge(3, 3)
g.addEdge(3, 6)
g.addEdge(6, 6)

print("Following is Breadth First Traversal"
      " (starting from vertex 2)")
print('graph length ', len(g.graph))
g.BFS()
