package datastructure.array;

/**
 * Given an integer array nums, rotate the array to the right by k steps, where
 * k is non-negative.
 * 
 * Example 1:
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * 
 * Example 2:
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * 
 * Constraints:
 * 1 <= nums.length <= 10^5
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 */
public class RotateArray {

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        rotate_3(nums, 3);
        print(nums);
    }

    public static void rotate_1(int[] nums, int k) {
        int[] rotated = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            rotated[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < rotated.length; i++) {
            nums[i] = rotated[i];
        }
    }

    public static void rotate_2(int[] nums, int k) {
        int effectiveK = k % nums.length;
        if (effectiveK == 0)
            return;
        int[] rotated = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            rotated[(i + effectiveK) % nums.length] = nums[i];
        }
        for (int i = 0; i < rotated.length; i++) {
            nums[i] = rotated[i];
        }
    }

    public static void rotate_3(int[] nums, int k) {
        int effectiveK = k % nums.length;
        if (effectiveK == 0)
            return;
        int[] moveToHead = new int[effectiveK];
        for (int i = 0; i < effectiveK; i++) {
            moveToHead[effectiveK - 1 - i] = nums[nums.length - 1 - i];
        }
        for (int i = 0; i < nums.length - effectiveK; i++) {
            nums[nums.length - 1 - i] = nums[nums.length - 1 - effectiveK - i];
        }
        for (int i = 0; i < effectiveK; i++) {
            nums[i] = moveToHead[i];
        }
    }

    private static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.err.print(array[i]);
            System.err.print(", ");
        }
        System.out.println();
    }

    public static void rotate_Perfect(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length-1); // [7,6,5,4,3,2,1]
        reverse(nums, 0, k-1); // [5,6,7,4,3,2,1]
        reverse(nums, k, nums.length-1); // [5,6,7,1,2,3,4]
    }

    public static void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
