package datastructure.array;

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining
 * the relative order of the non-zero elements.
 * 
 * Note that you must do this in-place without making a copy of the array.
 * 
 * Example 1:
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * 
 * Example 2:
 * Input: nums = [0]
 * Output: [0]
 * 
 * Constraints:
 * 1 <= nums.length <= 10^4
 * -231 <= nums[i] <= 231 - 1
 */
public class MoveZeros {

    public static void main(String[] args) {
        int[] nums = new int[] { 0, 1, 0, 3, 12 };
        moveZeroes(nums);
        print(nums);

        nums = new int[] { 0 };
        moveZeroes(nums);
        print(nums);

        nums = new int[] { 0, 0, 1 };
        moveZeroes(nums);
        print(nums);
    }

    public static void moveZeroes(int[] nums) {
        int[] nonZeros = new int[nums.length];
        int nonZerosLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nonZeros[nonZerosLen++] = nums[i];
                nums[i] = 0;
            }
        }
        for (int i = 0; i < nonZerosLen; i++) {
            nums[i] = nonZeros[i];
        }
    }

    public static void moveZeroes2(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int nonZeroIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[nonZeroIndex++] = nums[i]; // Move non-zero to array begin and keep the order.
            }
        }

        // Fill array end with zeros
        while (nonZeroIndex < nums.length) {
            nums[nonZeroIndex++] = 0;
        }
    }

    private static void print(int[] nums) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]).append(",");
        }
        sb.deleteCharAt(sb.length() - 1).append("]");
        System.out.println(sb.toString());
    }

}
