# Section 9. Queue and Stack
__Pros__
* Fast opereations
* Fast peek
* Ordered

__Cons__
* Slow search

## Stack: LIFO
### Big O notations:
* search: O(n)
* pop: O(1)
* push: O(1)
* peek: O(1)

## Queue: LILO
### Big O notations:
* search: O(n)
* enqueue: O(1)
* dequeue: O(1)
* peek: O(1)

## Java
### Queue
https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Queue.html

> A collection designed for holding elements prior to processing. Besides basic Collection operations, queues provide additional insertion, extraction, and inspection operations. Each of these methods exists in two forms: one throws an exception if the operation fails, the other returns a special value (either null or false, depending on the operation). The latter form of the insert operation is designed specifically for use with capacity-restricted Queue implementations; in most implementations, insert operations cannot fail.

| |Throw exception | Return special value |
| - | - | - |
| Insert | add(e) | offer(e) |
| Remove | remove() | poll() |
| Examine | element() | peek() |

### Stack
https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Stack.html

> The Stack class represents a last-in-first-out (LIFO) stack of objects. It extends class Vector with five operations that allow a vector to be treated as a stack. The usual push and pop operations are provided, as well as a method to peek at the top item on the stack, a method to test for whether the stack is empty, and a method to search the stack for an item and discover how far it is from the top.