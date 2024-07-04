# Section 7 Hash Tables
Hash algorithm is idempotent

__How does hash table work?__

key > hash > index/address

There're are a lot hash function. The hash function for hash table should be very fast.

### Big O notations of Hash Tables Operations
* insert: O(1)
* access: O(1)
* delete: O(1)
* search: O(1)
* push: O(n)

__Pros__
* Fast lookups
* Fast insertion
* Flexible size

__Cons__
* Unordered
* Slow insertion in case of key collision.

#### Limitations of Hash Tables: Collision

A hash table collision occurs when two different keys hash to the same index in a hash table. Hash tables use a hash function to compute an index into an array of buckets or slots, from which the desired value can be found. Here’s a more detailed explanation:

1. __Hash Function__: A hash function takes an input (or 'key') and returns an integer, which is then used as an index in the hash table.
2. __Index Calculation__: This integer index is usually taken modulo the size of the array (hash table) to ensure it fits within the bounds of the array.
3. __Collision__: A collision occurs when two different keys produce the same index after being processed by the hash function. Since the hash table uses this index to store the value, it can only store one value at each index. Therefore, a method is needed to handle these collisions.

Collision impacts the operation speed.

![image](./hash_table_collision.png)

### Insertion Order

### Sets


## Reference
MD5 hash: https://www.miraclesalad.com/webtools/md5.php

Hash table animation: https://www.cs.usfca.edu/~galles/visualization/OpenHash.html

Wiki: https://en.wikipedia.org/wiki/Hash_table

Collision resolution: https://en.wikipedia.org/wiki/Hash_table#Collision_resolution

Compare hash tables of different programming languages:<br>
https://en.wikipedia.org/wiki/Comparison_of_programming_languages_(associative_array)#

