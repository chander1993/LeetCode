## Graphs


## DEPTH FIRST SEARCH

## BREADTH FIRST SEARCH

## Topological sort
1. create indegree
2. create adjacency list with prerequisites
3. add nodes into the queue with indegree 0
4. visit the nodes from queue. for each adjacency node reduce the indegree.  if indegree of the adjancency node is '0' add them also to queue.
5. do the same until the queue is empty.

## shortest/ cheapest path within K stops
BFS: 
* can work for unweighted graph.
https://www.geeksforgeeks.org/shortest-path-unweighted-graph/
Directed graph:
1. create adjacency list. Map<source, Map<destination, cost>>
2. create a Priority queue (min heap) and initialize with int[]{0, src_vertex}
3. do a breadth first search until you visit the destination or until K stops.
4. in each iteration before adding adjacent vertices to heap add the current price with the adjacent vertex price.
6. if dest is not found until K stops return -1.

O(n) + O(K log K)

## Eulerian Path

* hitting every edge in the graph exactly once.
* every node should have even in degree. every start and the end node should have odd in degree.
* Although there is a special case called 'Eulerian tour': where the start and end node is same. so in this case all the nodes in the graph will have even indegrees.
