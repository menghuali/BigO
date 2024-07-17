# Section 13. Algorithm: Sorting

### Why sorting is important to interview?
Sorting becomes critical when input is becoming larger and larger, and you'll need custom sorting algorithm.

## Bubbke Sort
https://en.wikipedia.org/wiki/Bubble_sort

Bubble sort, sometimes referred to as sinking sort, is a simple sorting algorithm that repeatedly steps through the input list element by element, comparing the current element with the one after it, swapping their values if needed. These passes through the list are repeated until no swaps have to be performed during a pass, meaning that the list has become fully sorted. The algorithm, which is a comparison sort, is named for the way the larger elements "bubble" up to the top of the list.

This simple algorithm performs poorly in real-world use and is used primarily as an educational tool. More efficient algorithms such as quicksort, timsort, or merge sort are used by the sorting libraries built into popular programming languages such as Python and Java. However, if parallel processing is allowed, bubble sort sorts in O(n) time, making it considerably faster than parallel implementations of insertion sort or selection sort which do not parallelize as effectively.

Time complexity: O(n^2)

Space complexity: O(1)

## Selection Sort
https://en.wikipedia.org/wiki/Selection_sort

The algorithm divides the input list into two parts: a sorted sublist of items which is built up from left to right at the front (left) of the list and a sublist of the remaining unsorted items that occupy the rest of the list. Initially, the sorted sublist is empty and the unsorted sublist is the entire input list. The algorithm proceeds by finding the smallest (or largest, depending on sorting order) element in the unsorted sublist, exchanging (swapping) it with the leftmost unsorted element (putting it in sorted order), and moving the sublist boundaries one element to the right.

Time complexity: O(n^2)

Space complexity: O(1)

## Insertion Sort
https://en.wikipedia.org/wiki/Insertion_sort

Insertion sort iterates, consuming one input element each repetition, and grows a sorted output list. At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there. It repeats until no input elements remain.

Time complexity: O(n^2)

Space complexity: O(1)

## Merge Sort
https://en.wikipedia.org/wiki/Merge_sort

In computer science, merge sort (also commonly spelled as mergesort) is an efficient, general-purpose, and comparison-based sorting algorithm. Most implementations produce a stable sort, which means that the relative order of equal elements is the same in the input and output. Merge sort is a divide-and-conquer algorithm that was invented by John von Neumann in 1945.A detailed description and analysis of bottom-up merge sort appeared in a report by Goldstine and von Neumann as early as 1948.

Conceptually, a merge sort works as follows:
1. Divide the unsorted list into n sublists, each containing one element (a list of one element is considered sorted).
2. Repeatedly merge sublists to produce new sorted sublists until there is only one sublist remaining. This will be the sorted list.

Time complexity: O(n log(n))

Space complexity: O(n)

## Quicksort
https://en.wikipedia.org/wiki/Quicksort

Quicksort is an efficient, general-purpose sorting algorithm. Quicksort was developed by British computer scientist Tony Hoare in 1959 and published in 1961. It is still a commonly used algorithm for sorting. Overall, it is slightly faster than merge sort and heapsort for randomized data, particularly on larger distributions.

Quicksort is a divide-and-conquer algorithm. It works by selecting a 'pivot' element from the array and partitioning the other elements into two sub-arrays, according to whether they are less than or greater than the pivot. For this reason, it is sometimes called partition-exchange sort.[4] The sub-arrays are then sorted recursively. This can be done in-place, requiring small additional amounts of memory to perform the sorting.

Time complexity: O(n log(n))

Space complexity: O(n)

## Reference
Sorting algorithms: https://en.wikipedia.org/wiki/Sorting_algorithm

Mind Map: https://coggle.it/diagram/W5E5tqYlrXvFJPsq/t/master-the-interview-click-here-for-course-link

Total sorting algorithm animations: https://www.toptal.com/developers/sorting-algorithms

Big O Cheat Sheet: https://www.bigocheatsheet.com/

Dancing Algorithms (for fun): https://www.youtube.com/user/AlgoRythmics/videos

Sorting animations: https://visualgo.net/en/sorting

Stable algorithms: https://stackoverflow.com/questions/1517793/what-is-stability-in-sorting-algorithms-and-why-is-it-important