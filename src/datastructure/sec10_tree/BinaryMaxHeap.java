package datastructure.sec10_tree;

import java.util.Arrays;

/**
 * Binary Maximum Heap implementation.
 * 
 * Reference:
 * https://en.wikipedia.org/wiki/Binary_heap
 * https://visualgo.net/en/heap
 */
public class BinaryMaxHeap {

    private int[] heap;

    private int size;

    /**
     * Create an empty heap
     * 
     * @param capacity heap capacity
     */
    public BinaryMaxHeap(int capacity) {
        heap = new int[capacity];
        size = 0;
    }

    /**
     * Create a heap with numbers
     * 
     * @param array    array of numbers
     * @param capacity heap capacity
     */
    public BinaryMaxHeap(int[] array, int capacity) {
        if (array != null && array.length > capacity) {
            throw new IllegalArgumentException(String.format(
                    "Initial array length (%d) cannot be larger than heap capacity (%d)", array.length, capacity));
        }
        heap = new int[capacity];
        size = 0;
        if (array != null) {
            // Copy numbers to heap
            System.arraycopy(array, 0, heap, 0, array.length);
            size = array.length;
            // Sort heap numbers by down-heap each non-leafe nodes, from right to left.
            for (int i = parent(size - 1); i >= 0; i--) {
                down(i);
            }
        }
    }

    @Override
    public String toString() {
        return "BinaryMaxHeap {size=" + size + ", array=" + Arrays.toString(Arrays.copyOf(heap, size)) + "}";
    }

    public void print() {
        System.out.println(toString());
    }

    /**
     * Insert a number
     * 
     * @param num number to insert
     */
    public void insert(int num) {
        heap[size++] = num;
        up(size - 1);
    }

    /**
     * Extract root
     * 
     * @return root value
     */
    public int extract() {
        if (size == 0) {
            throw new IndexOutOfBoundsException(toString());
        }
        int root = heap[0];
        heap[0] = heap[--size];
        down(0);
        return root;
    }

    /**
     * Search a number
     * 
     * @param num number to search
     * @return Return index of the number; return -1 if number not found.
     */
    public int search(int num) {
        return search(0, num);
    }

    /**
     * Delete the element of the given index
     * 
     * @param index index of the element to be deleted
     * @return value of the deteled element
     */
    public int delete(int index) {
        validateIndex(index);
        int deletedVal = heap[index];
        heap[index] = heap[0] + 1;
        up(index);
        extract();
        return deletedVal;
    }

    /**
     * Replace value
     * 
     * @param index index of the element to be replaced
     * @param num   new number
     * @return new index of the new number
     */
    public int replace(int index, int num) {
        validateIndex(index);
        int oldVal = heap[index];
        heap[index] = num;
        if (num > oldVal) {
            return up(index);
        }
        if (num < oldVal) {
            return down(index);
        }
        return index;
    }

    /**
     * Validate index
     * 
     * @param index index to validate
     * @throws IndexOutOfBoundsException Throw this exception if index is invalid.
     */
    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.format("size=%d, index=%d", size, index));
        }
    }

    /**
     * Search a number
     * 
     * @param index the index to begin search, will search the element of index and
     *              its children if any.
     * @param num   number to search
     * @return Return the index of the number; return -1 if number not found in the
     *         heap.
     */
    private int search(int index, int num) {
        if (index >= size) {
            return -1;
        }
        if (heap[index] == num) {
            return index;
        }
        if (heap[index] < num) {
            return -1;
        }
        int left = search(leftChildIndex(index), num);
        if (left >= 0) {
            return left;
        }
        return search(rightChildIndex(index), num);
    }

    /**
     * Down-heap: restore the heap property by comparing and possibly swapping a
     * node with one of its children.
     * 
     * @param index The index of element to be down-heaped.
     * @return new index of the element
     */
    private int down(int index) {
        validateIndex(index);
        int left = leftChildIndex(index);
        int right = rightChildIndex(index);
        while (index < size && left < size) {
            int maxChild = left;
            if (right < size && heap[left] < heap[right]) {
                maxChild = right;
            }
            if (heap[maxChild] <= heap[index]) {
                break;
            }
            int currentVal = heap[index];
            heap[index] = heap[maxChild];
            heap[maxChild] = currentVal;
            index = maxChild;
            left = leftChildIndex(index);
            right = rightChildIndex(index);
        }
        return index;
    }

    /**
     * Up-heap: restore the heap property by comparing and possibly swapping a node
     * with its parent.
     * 
     * @param index The index of element to be up-heaped.
     * @return new index of the element
     */
    private int up(int index) {
        validateIndex(index);
        int parent = parent(index);
        while (index > 0 && heap[index] > heap[parent]) {
            int temp = heap[index];
            heap[index] = heap[parent];
            heap[parent] = temp;
            index = parent;
            parent = parent(index);
        }
        return index;
    }

    /**
     * Calculate the index of left child of an element
     * 
     * @param index index of the element
     * @return index of left child of the element
     */
    private int leftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    /**
     * Calculate the index of right child of an element
     * 
     * @param index index of the element
     * @return index of right child of the element
     */
    private int rightChildIndex(int index) {
        return 2 * index + 2;
    }

    /**
     * Calculate the index of the parent of an element
     * 
     * @param index index of the element
     * @return index of the parent of the element
     */
    private int parent(int index) {
        return Math.floorDiv(index - 1, 2);
    }

    public static void main(String[] args) {
        BinaryMaxHeap heap = new BinaryMaxHeap(100);
        // Test insert
        heap.insert(58);
        heap.insert(95);
        heap.insert(89);
        heap.insert(24);
        heap.insert(30);
        heap.insert(69);
        heap.insert(99);
        heap.insert(70);
        heap.insert(90);
        heap.print();

        // Test extrat
        System.out.println(heap.extract());
        heap.print();
        System.out.println(heap.extract());
        heap.print();

        // Test search
        System.out.println(String.format("%d: %d", 90, heap.search(90)));
        System.out.println(String.format("%d: %d", 89, heap.search(89)));
        System.out.println(String.format("%d: %d", 99, heap.search(99)));

        // Test delete
        heap.insert(10);
        heap.insert(20);
        heap.print();
        heap.delete(3);
        heap.print();

        // Test replace
        heap.replace(3, 99);
        heap.print();

        // Test create heap with numbers
        (new BinaryMaxHeap(new int[] { 1, 2, 3, 5, 6, 7, 9, 12, 14, 17 }, 15)).print();
        (new BinaryMaxHeap(new int[] { 11, 13, 19, 5, 17, 10, 6, 18, 2, 9 }, 15)).print();
    }

}
