# Input:
#        graph[][] = { {0,   5,  INF, 10},
#                     {INF,  0,  3,  INF},
#                     {INF, INF, 0,   1},
#                     {INF, INF, INF, 0} }
# which represents the following graph
#              10
#        (0)------->(3)
#         |         /|\
#       5 |          |
#         |          | 1
#        \|/         |
#        (1)------->(2)
#             3
# Note that the value of graph[i][j] is 0 if i is equal to j
# And graph[i][j] is INF (infinite) if there is no edge from vertex i to j.
#
# Output:
# Shortest distance matrix
#       0      5      8      9
#     INF      0      3      4
#     INF    INF      0      1
#     INF    INF    INF      0

# A utility function to print the solution
def printSolution(dist):
    print "Following matrix shows the shortest distances\
 between every pair of vertices"
    for i in range(V):
        for j in range(V):
            if(dist[i][j] == INF):
                print "%7s" %("INF"),
            else:
                print "%7d\t" %(dist[i][j]),
            if j == V-1:
                print ""
V = 4
INF = 999999

graph = [[0,5,INF,10],
             [INF,0,3,INF],
             [INF, INF, 0,   1],
             [INF, INF, INF, 0]
        ]
dist = map(lambda row:map(lambda column:column, row), graph)
for k in range(V):
    for i in range(V):
        for j in range(V):
            dist[i][j] = min(dist[i][j],
                             dist[i][k] + dist[k][j]
                             )

printSolution(dist)
print(dist[0][3])
