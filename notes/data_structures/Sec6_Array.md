# Section 6 Array

## Static Array & Dymaic Array
Static array: size of array is static

Dynamic array: size of array is dynamic

## Operation of dynamic array and Big O notations:
* access: O(1)
* append: O(1), but can be O(n). It depends on the language. E.g. JavaScript will copy the existing array to a new one and append the new element to the end if the exisint array is full.
* insert: O(n)
* delete: O(n)
* search: O(n)

__Pros__
* Fast access
* Ordered

__Cons__
* Slow search
* Slow insertion
* Slow deltion
* Fixed size

## String
Treat string queustions as array questions because a string is barely an array of characters. For example, when resovle problem of reverse a string, you should convert a string to an array of characters, then implement reversal function, consturct the string from the reversed characaters array and return it.

