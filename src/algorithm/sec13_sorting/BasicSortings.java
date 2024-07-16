package algorithm.sec13_sorting;

import java.util.Arrays;
import java.util.function.Consumer;

public class BasicSortings {

    /**
     * Bubble sort, sometimes referred to as sinking sort, is a simple sorting
     * algorithm that repeatedly steps through the input list element by element,
     * comparing the current element with the one after it, swapping their values if
     * needed. These passes through the list are repeated until no swaps have to be
     * performed during a pass, meaning that the list has become fully sorted. The
     * algorithm, which is a comparison sort, is named for the way the larger
     * elements "bubble" up to the top of the list.
     */
    public static void bubble(int[] numbers) {
        boolean swapped = false;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j + 1];
                    numbers[j + 1] = numbers[j];
                    numbers[j] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            } else {
                swapped = false;
            }
        }
    }

    /**
     * The algorithm divides the input list into two parts: a sorted sublist of
     * items which is built up from left to right at the front (left) of the list
     * and a sublist of the remaining unsorted items that occupy the rest of the
     * list. Initially, the sorted sublist is empty and the unsorted sublist is the
     * entire input list. The algorithm proceeds by finding the smallest (or
     * largest, depending on sorting order) element in the unsorted sublist,
     * exchanging (swapping) it with the leftmost unsorted element (putting it in
     * sorted order), and moving the sublist boundaries one element to the right.
     */
    public static void selection(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            int min = i;
            for (int j = 1 + i; j < numbers.length; j++) {
                if (numbers[j] < numbers[min]) {
                    min = j;
                }
            }
            if (min != i) { // swap when needed
                int temp = numbers[min];
                numbers[min] = numbers[i];
                numbers[i] = temp;
            }
        }
    }

    /**
     * Insertion sort iterates, consuming one input element each repetition, and
     * grows a sorted output list. At each iteration, insertion sort removes one
     * element from the input data, finds the location it belongs within the sorted
     * list, and inserts it there. It repeats until no input elements remain.
     */
    public static void insertion(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            int j = i - 1;
            int current = numbers[i];
            while (j > -1 && numbers[j] > current) {
                numbers[j + 1] = numbers[j];
                j--;
            }
            numbers[j + 1] = current;
        }
    }

    public static void main(String[] args) {
        int[] numbers = new int[] { 99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0 };
        sort(numbers, BasicSortings::bubble);
        sort(numbers, BasicSortings::selection);
        sort(numbers, BasicSortings::insertion);
    }

    private static void sort(int[] numbers, Consumer<int[]> function) {
        int[] clonedNumbers = Arrays.copyOf(numbers, numbers.length);
        function.accept(clonedNumbers);
        StringBuilder sorted = new StringBuilder();
        for (int i : clonedNumbers) {
            sorted.append(i).append(", ");
        }
        System.out.println(sorted.toString());
    }

}
