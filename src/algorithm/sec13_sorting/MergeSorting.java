package algorithm.sec13_sorting;

public class MergeSorting {

    public static int[] sort(int[] numbers) {
        if (numbers.length == 1)
            return numbers;
        else {
            // divide the array into two
            int halfLen = Math.round((float) numbers.length / 2);
            var left = new int[halfLen];
            var right = new int[numbers.length - halfLen];
            for (int i = 0; i < halfLen; i++)
                left[i] = numbers[i];
            for (int i = 0; i + halfLen < numbers.length; i++)
                right[i] = numbers[i + halfLen];

            // Sort two sub-arrays and merge sorted ones.
            return merge(sort(left), sort(right));
        }
    }

    private static int[] merge(int[] left, int[] right) {
        var merged = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;
        // Compare two sub-arrays and add the samller number to the merged array
        while (i < left.length && j < right.length)
            if (left[i] < right[j]) {
                merged[k++] = left[i++];
            } else {
                merged[k++] = right[j++];
            }

        // Decide the sub-array which has remaining numbers.
        int l;
        int[] remain;
        if (i < left.length) {
            l = i;
            remain = left;
        } else {
            l = j;
            remain = right;
        }
        // Add the remaining numbers to the merged array
        while (l < remain.length)
            merged[k++] = remain[l++];
        return merged;
    }

    public static void main(String[] args) {
        int[] numbers = new int[] { 99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0 };
        int[] sorted = sort(numbers);
        StringBuilder sb = new StringBuilder();
        for (int i : sorted) {
            sb.append(i).append(", ");
        }
        System.out.println(sb.toString());
    }

}
