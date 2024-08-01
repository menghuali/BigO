# Section 10. Trees
Sample: abstract syntax tree

## [Binary Tree](https://en.wikipedia.org/wiki/Binary_tree)
* Each node can have up to two child nodes
* Perfect Binary Tree vs Full Binary Tree

### Perfect Binary Tree
* The number of lower-level nodes is twice the number of upper-level nodes.
* The number of a level equals to all the number of all upper-levels nodes plus one. E.g., level-2 has 4 nodes, which equals to the level-0 nodes count (2), plus level-1 nodes count (2), plus one. Aka: 4 = 2 + 1 + 1
* The total number of nodes is __2^levels - 1__. E.g., a 3-level tree have 7 nodes, aka 2^3 - 1 = 7.

#### Big O
* search: O(log N)
* insert: O(log N)
* delete: O(log N)

### Meaning of O(log N)
The steps of an operation equals to the 2-based log of N (the number of total nodes). E.g., searching a node in a Perfect Binary Tree with 7 nodes will be log(7) = 2.8073, (about 3 steps). It's also called __Divide & Conquer__. 

### [Binary Search Tree (BST)](https://en.wikipedia.org/wiki/Binary_search_tree)
* The child nodes on the left are less than the parent node
* The child nodes on the right are bigger than the parent node
* A node can have up to 2 child nodes
  
Animation: https://visualgo.net/en/bst?slide=1

__Pros__
* Better than O(n)
* Ordered
* Flexible size

__Cons__
* No O(1) operations

### Balanced vs Unbalanced BST
https://opendatastructures.org/versions/edition-0.1d/ods-java/node37.html

#### AVL Tree
https://en.wikipedia.org/wiki/AVL_tree

https://medium.com/basecs/the-little-avl-tree-that-could-86a3cae410c7

#### Red-black Tree
https://en.wikipedia.org/wiki/Red%E2%80%93black_tree

### Java
* [JGraphT](https://jgrapht.org/): A free Java graph library that provides mathematical graph-theory objects and algorithms. It includes various types of trees, including BST.

## [Binary Heap](https://en.wikipedia.org/wiki/Binary_heap)
* Shape property
  > a binary heap is a complete binary tree; that is, all levels of the tree, except possibly the last one (deepest) are fully filled, and, if the last level of the tree is not complete, the nodes of that level are filled from left to right.
* Heap property:
  * Max heap: a node is greater than its lower nodes
  * Min heap: a node is less than its lower nodes

Visualized: https://visualgo.net/en/heap?slide=1

> A binary heap is a heap data structure that takes the form of a binary tree. Binary heaps are a common way of implementing [priority queues](https://en.wikipedia.org/wiki/Priority_queue).

Operations:
* Insert
* Extract: delete the root from the heap
* Insert than extract
* Search
* Delete
* Decrease or increase key: Replaces the value of a node with a given value with a lower value, and the increase key operation does the same but with a higher value. 

Big O:
* search: O(N)
* insert: O(log N)
* delete: O(log N)

Use cases:
* __Priority queue__: https://en.wikipedia.org/wiki/Priority_queue
* Comparision, e.g. find the transactions greater than 100 dollors.
* Sorting

Pros:
* No need to rebalance
* Better than O(n)
* Priority
* Flexible size
* Fast inert
* Find max/min: O(n)

Cons:
* Slow lookup

### Java
* [PriorityQueue](https://docs.oracle.com/en%2Fjava%2Fjavase%2F17%2Fdocs%2Fapi%2F%2F/java.base/java/util/PriorityQueue.html): An unbounded priority queue based on a priority heap.

### [Priority Queue](https://en.wikipedia.org/wiki/Priority_queue)
> In computer science, a priority queue is an abstract data type similar to a regular queue or stack abstract data type. Each element in a priority queue has an associated priority. In a priority queue, elements with high priority are served before elements with low priority. In some implementations, if two elements have the same priority, they are served in the same order in which they were enqueued. In other implementations, the order of elements with the same priority is undefined.

## [Trie](https://en.wikipedia.org/wiki/Trie)
> In computer science, a trie (/ˈtraɪ/, /ˈtriː/), also called digital tree or prefix tree, is a type of k-ary search tree, a tree data structure used for locating specific keys from within a set. These keys are most often strings, with links between nodes defined not by the entire key, but by individual characters. In order to access a key (to recover its value, change it, or remove it), the trie is traversed depth-first, following the links between nodes, which represent each character in the key.
> 
> Tries are a form of string-indexed look-up data structure, which is used to store a dictionary list of words that can be searched on in a manner that allows for efficient generation of completion lists.[9][10]: 1  A prefix trie is an ordered tree data structure used in the representation of a set of strings over a finite alphabet set, which allows efficient storage of words with common prefixes.

Big O:
* O(length of word)

### Java
* [Apache Commons Collections - Trie](https://commons.apache.org/proper/commons-collections/apidocs/org/apache/commons/collections4/Trie.html): Defines the interface for a prefix tree, an ordered tree data structure.

## Reference
Mind Tree: https://coggle.it/diagram/W5E5tqYlrXvFJPsq/t/master-the-interview-click-here-for-course-link


