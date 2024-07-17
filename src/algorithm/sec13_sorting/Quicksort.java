package algorithm.sec13_sorting;

public class Quicksort {

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

    public static void sort(int[] numbers) {
        if (numbers.length > 1)
            pivot(numbers, 0, numbers.length - 1);
        print(numbers);
    }

    private static void pivot(int[] numbers, int left, int right) {
        int len = right - left + 1;
        if (len == 2) {
            // Swap the number if left and right is adjacent and left is greater than left.
            if (numbers[left] > numbers[right]) {
                var temp = numbers[left];
                numbers[left] = numbers[right];
                numbers[right] = temp;
            }
        } else if (len > 2) {
            int l = left;
            int r = right;
            // Pick the last element as 'pivot' and devide the current range of the array
            while (l < r)
                if (numbers[l] <= numbers[r]) {
                    l++;
                } else {
                    var temp = numbers[l];
                    numbers[l] = numbers[r - 1];
                    numbers[r - 1] = numbers[r];
                    numbers[r] = temp;
                    r--;
                }
            // Pivot the sub-range left to the pivot
            pivot(numbers, left, r - 1);
            // Pivot the sub-range right to the pivot
            pivot(numbers, r + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] numbers = new int[] { 32, 88, 194, 165, 95, 126, 67, 187, 94, 167, 168, 111, 152, 139, 138, 80, 196, 136,
                20, 149, 91, 75, 40, 108, 21, 44, 47, 84, 189, 74, 73, 34, 181, 43, 99, 114, 7, 191, 120, 24, 129, 121,
                42, 79, 53, 83, 140, 182, 132, 190, 137, 127, 109, 169, 19, 4, 71, 86, 173, 171, 63, 105, 119, 100, 125,
                160, 145, 48, 90, 153, 131, 41, 155, 28, 143, 17, 157, 46, 103, 144, 45, 72, 26, 177, 11, 116, 193, 25,
                164, 98, 8, 148, 60, 154, 198, 128, 115, 69, 22, 61 };
        sort(numbers);
    }

}
