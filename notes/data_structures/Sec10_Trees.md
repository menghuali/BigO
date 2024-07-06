# Section 10. Trees
Sample: abstract syntax tree

## Binary Tree
https://en.wikipedia.org/wiki/Binary_tree#:~:text=In%20computer%20science%2C%20a%20binary,child%20and%20the%20right%20child.

* Each node can have up to two child nodes
* Perfect Binary Tree vs Full Binary Tree

### Perfect Binary Tree
#### Important Characters
* The number of lower-level nodes is twice the number of upper-level nodes.
* The number of a level equals to all the number of all upper-levels nodes plus one. E.g., level-2 has 4 nodes, which equals to the level-0 nodes count (2), plus level-1 nodes count (2), plus one. Aka: 4 = 2 + 1 + 1
* The total number of nodes is __2^levels - 1__. E.g., a 3-level tree have 7 nodes, aka 2^3 - 1 = 7.

#### Big O
* search: O(log N)
* insert: O(log N)
* delete: O(log N)

#### Meaning of O(log N)
The steps of an operation equals to the 2-based log of N (the number of total nodes). E.g., searching a node in a Perfect Binary Tree with 7 nodes will be log(7) = 2.8073, (about 3 steps). It's also called __Divide & Conquer__. 

## Binary Search Tree (BST)
https://en.wikipedia.org/wiki/Binary_search_tree

https://visualgo.net/en/bst?slide=1

* The child nodes on the left are less than the parent node
* The child nodes on the right are bigger than the parent node
* A node can have up to 2 child nodes

__Pros__
* Better than O(n)
* Ordered
* Flexible size

__Cons__
* No O(1) operations

### Balanced vs Unbalanced BST
https://opendatastructures.org/versions/edition-0.1d/ods-java/node37.html

## Reference
Mind Tree: https://coggle.it/diagram/W5E5tqYlrXvFJPsq/t/master-the-interview-click-here-for-course-link


