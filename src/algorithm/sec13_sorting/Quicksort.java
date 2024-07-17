package algorithm.sec13_sorting;

public class Quicksort {

    public static int[] sort(int[] numbers) {
        if (numbers.length == 1) {
            return numbers;
        } else if (numbers.length == 2) {
            if (numbers[0] > numbers[1]) {
                var temp = numbers[0];
                numbers[0] = numbers[1];
                numbers[1] = temp;
            }
            return numbers;
        } else {
            int pivot = pivot(numbers);
            return merge(sort(subarray(numbers, 0, pivot)), numbers[pivot],
                    sort(subarray(numbers, pivot + 1, numbers.length)));
        }
    }

    private static int[] merge(int[] left, int pivot, int[] right) {
        int leftLen = (left == null || left.length == 0) ? 0 : left.length;
        int rightLen = (right == null || right.length == 0) ? 0 : right.length;
        var merge = new int[leftLen + rightLen + 1];
        int i = 0;
        if (left != null && left.length > 0)
            for (; i < left.length; i++) {
                merge[i] = left[i];
            }
        merge[i++] = pivot;
        if (right != null && right.length > 0)
            for (int j = 0; j < right.length; j++) {
                merge[i++] = right[j];
            }
        return merge;
    }

    private static int[] subarray(int[] array, int start, int end) {
        var len = end - start;
        int[] subarray = null;
        if (len > 0) {
            subarray = new int[len];
            for (int i = 0; i < subarray.length; i++) {
                subarray[i] = array[start + i];
            }
        }
        return subarray;
    }

    private static int pivot(int[] numbers) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] <= numbers[right]) {
                left++;
            } else {
                var temp = numbers[left];
                numbers[left] = numbers[right - 1];
                numbers[right - 1] = numbers[right];
                numbers[right] = temp;
                right--;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        int[] numbers = new int[] { 3, 7, 8, 5, 2, 1, 9, 5, 4 };
        print(sort(numbers));

    }

    private static void print(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            System.out.println("[]");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            sb.append(numbers[i]).append(", ");
        }
        System.out.println(sb.toString());
    }

}
