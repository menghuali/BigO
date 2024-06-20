package datastructure.array;

import java.util.*;

/**
 * Merge two sorted integer arrays. For example: merge [0, 3, 4, 31] and [4, 6,
 * 30]. The result shall be [0, 3, 4, 4, 6, 30, 31]
 */
public class MergeSortedArrays {

    public static void main(String[] args) {
        solution1();
        solution2();
        solution3();
    }

    private static void solution2() {
        System.out.println("\n\nSolution 2");
        print(merge2(new int[] { 0, 3, 4, 31 }, new int[] { 4, 6, 30 }));
        print(merge2(new int[] { 0, 5 , 9}, new int[] { 3, 6, 9 }));
        print(merge2(new int[] { 0, 1, 1, 1}, new int[] { -1, 1, 1, 1}));
    }

    private static void solution1() {
        System.out.println("\n\nSolution 1");
        print(merge(new int[] { 0, 3, 4, 31 }, new int[] { 4, 6, 30 }));
        print(merge(new int[] { 0, 5 }, new int[] { 3, 6, 9 }));
        print(merge(new int[] { 0, 1, 1, 1}, new int[] { -1, 1, 1, 1}));
    }

    private static void solution3() {
        System.out.println("\n\nSolution 3");
        print(merge3(new int[] { 0, 3, 4, 31 }, new int[] { 4, 6, 30 }));
        print(merge3(new int[] { 0, 5 }, new int[] { 3, 6, 9 }));
        print(merge3(new int[] { 0, 1, 1, 1}, new int[] { -1, 1, 1, 1}));
    }

    // Create an new array where the length is sum of two input arrays.
    // Create an index for each input array: index1 and index2
    // Loop the new array with index i. For each loop, get the current item from both array: array1[index1] and array2[index2]
    //      If the index1 reachs the end of the array, then ...
    //          new_array[i] = array2[index2]; increase index2 by one;
    //      If the index2 reachs the end of the array, then ...
    //          new_array[i] = array1[index1]; increase index1 by one;
    //      If the array1[index1] is greater than array2[index2], then...
    //          new_array[i] = array2[index2]; increase index2 by one.
    //      else...
    //          new_array[i] = array1[index1]; increase index1 by one.
    // 
    // For example: [0, 5], [3, 6, 9]
    // 0) [0], [5], [3, 6, 9]
    // 1) [0, 3], [5], [6, 9]
    // 2) [0, 3, 5], [], [6, 9]
    // 3) [0, 3, 5], [], [6, 9]
    // 4) [0, 3, 5, 6], [], [9]
    // 5) [0, 3, 5, 6, 9], [], []

    private static int[] merge(int[] array1, int[] array2) {
        if (array1 == null || array1.length == 0) {
            return array2;
        }
        if (array2 == null || array2.length == 0) {
            return array1;
        } 
        var merged = new int[array1.length + array2.length];
        int index1 = 0, index2 = 0;
        for (int i = 0; i < merged.length; i++) {
            if (index1 == array1.length) {
                merged[i] = array2[index2++];
            } else if (index2 == array2.length) {
                merged[i] = array1[index1++];
            } else if (array1[index1] > array2[index2]) {
                merged[i] = array2[index2++];
            } else {
                merged[i] = array1[index1++];
            }
        }
        return merged;
    }

    // Small improve solution 1.
    // If one of the index reaches the end of the array, break look and add the
    // remaining of the other array to the end of the merged array
    private static int[] merge2(int[] array1, int[] array2) {
        if (array1 == null || array1.length == 0) {
            return array2;
        }
        if (array2 == null || array2.length == 0) {
            return array1;
        } 
        
        var merged = new int[array1.length + array2.length];
        int index1 = 0, index2 = 0, i = 0;
        for (; i < merged.length; i++) {
            if (index1 == array1.length) {
                break;
            } else if (index2 == array2.length) {
                break;
            } else if (array1[index1] > array2[index2]) {
                merged[i] = array2[index2++];
            } else {
                merged[i] = array1[index1++];
            }
        }
        if (index1 < array1.length) {
            for (; i < merged.length; i++) {
                merged[i] = array1[index1++];
            }
        } else if (index2 < array2.length) {
            for (; i < merged.length; i++) {
                merged[i] = array2[index2++];
            }
        }
        return merged;
    }

    private static int[] merge3(int[] array1, int[] array2) {
        int i = 0, j = 0, k = 0;
        int[] merged = new int[array1.length + array2.length];
        while (i < array1.length && j < array2.length) {
            if (array1[i] > array2[j]) {
                merged[k++] = array2[j++];
            } else {
                merged[k++] = array1[i++];
            }
        }
        if (i < array1.length) {
            for (; i < array1.length; i++) {
                merged[k++] = array1[i];
            }
        } else if (j < array2.length) {
            for (; j < array2.length; j++) {
                merged[k++] = array2[j];
            }
        }
        return merged;
    }

    private static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.err.print(array[i]);
            System.err.print(", ");
        }
        System.out.println();
    }

}
