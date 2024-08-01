# Section 8. Linked List
__Concept__

_Singly Linked_: head -> element 1 -> element 2 -> ... -> tial -> null

_Doubly Linked_: head <> element 1 <> element 2 <> ... <> tial -> null

__Big O:__
* prepend: O(1)
* append: O(1)
* access: O(n)
* insert: O(n)
* delete: O(n)

__Pros__
* Fast insertion
* Fastt deletion
* Flexible size
* Ordered

__Cons__
* Slow access
* Slow search
* More memory

## Reference
Visualize Linked List: https://visualgo.net/en/list?slide=1

## Java
LinkedList: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/LinkedList.html

> Doubly-linked list implementation of the List and Deque interfaces. Implements all optional list operations, and permits all elements (including null).
> 
> All of the operations perform as could be expected for a doubly-linked list. Operations that index into the list will traverse the list from the beginning or the end, whichever is closer to the specified index.