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


## Reference
Sorting algorithms: https://en.wikipedia.org/wiki/Sorting_algorithm

Mind Map: https://coggle.it/diagram/W5E5tqYlrXvFJPsq/t/master-the-interview-click-here-for-course-link

Total sorting algorithm animations: https://www.toptal.com/developers/sorting-algorithms

Big O Cheat Sheet: https://www.bigocheatsheet.com/

Dancing Algorithms (for fun): https://www.youtube.com/user/AlgoRythmics/videos

Sorting animations: https://visualgo.net/en/sorting
