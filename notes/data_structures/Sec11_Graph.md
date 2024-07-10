# Section 11. Graph
https://en.wikipedia.org/wiki/Graph_(abstract_data_type)

Types of Graph
* Directed vs Undirected
* Weighted vs Unweighted
* Cyclic vs Acyclic

Methods to represents graph
* Edge list: https://en.wikipedia.org/wiki/Edge_list. E.g. ```[[0,2], [2,3], [2,1], [1,3]]```
* Adjacent list: https://en.wikipedia.org/wiki/Adjacency_list. E.g.```[[2,], [2,3], [0,1,3], [1,2]]```
* Adjacent matrix: https://en.wikipedia.org/wiki/Adjacency_matrix. See below example.
```
[
    0: [0,0,1,0],
    1: [0,0,1,1],
    2: [1,1,0,1],
    3: [0,1,1,0]
]
```
Also see: https://visualgo.net/en/graphds?slide=1

Pros:
* Relationship

Cons:
* Scaling is hard

## Reference
MindMap: https://coggle.it/diagram/W5E5tqYlrXvFJPsq/t/master-the-interview-click-here-for-course-link