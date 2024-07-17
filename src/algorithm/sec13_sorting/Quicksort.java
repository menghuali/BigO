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
        int[] numbers = new int[] { 99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0 };
        sort(numbers);
    }

}
