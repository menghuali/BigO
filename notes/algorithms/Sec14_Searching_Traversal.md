# Section 14. Algorithm: Searching + Traversal + BFS + DFS

## Linear Search
https://en.wikipedia.org/wiki/Linear_search#:~:text=In%20computer%20science%2C%20linear%20search,whole%20list%20has%20been%20searched.

In computer science, linear search or sequential search is a method for finding an element within a list. It sequentially checks each element of the list until a match is found or the whole list has been searched.

Time complexity: O(n)

## Binary Search
https://en.wikipedia.org/wiki/Binary_search

BST: https://en.wikipedia.org/wiki/Binary_search_tree

Time complexity: O(log(n))

## Traversal
* Graph traversal: https://en.wikipedia.org/wiki/Graph_traversal
* Tree traversal: https://en.wikipedia.org/wiki/Tree_traversal

### Search algorithms:
* Breadth First Seach (BFS): https://en.wikipedia.org/wiki/Breadth-first_search
* Depth First Search (DFS): https://en.wikipedia.org/wiki/Depth-first_search

#### BFS vs DFS
* Time complexity: both are O(n)
* BFS:
  * Pros: shortest path, closer nodes
  * Cons: more memory
* DFS:
  * Pros: less memory, does path exists?
  * Cons: slower

#### How to choose?
1. If you know a solution is not far from the root of the tree:<br>
   BFS

2. If the tree is very deep and solutions are rare:<br>
   BFS

3. If the tree is very wide:<br>
   DFS

4. If solutions are frequent but located deep in the tree:<br>
   DFS

5. Determining whether a path exists between two nodes:<br>
   DFS

6. Finding the shortest path:<br>
   BFS

## Reference
What is the time and space complexity of a breadth first and depth first tree traversal?<br>
https://stackoverflow.com/questions/9844193/what-is-the-time-and-space-complexity-of-a-breadth-first-and-depth-first-tree-tr
