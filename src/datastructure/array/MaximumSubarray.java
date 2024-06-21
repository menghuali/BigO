package datastructure.array;

/**
 * Given an integer array nums, find the subarray with the largest sum, and
 * return its sum.
 * 
 * Example 1:
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 * 
 * Example 2:
 * Input: nums = [1]
 * Output: 1
 * Explanation: The subarray [1] has the largest sum 1.
 * 
 * Example 3:
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 * 
 * Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 */
public class MaximumSubarray {

   public static void main(String[] args) {
      System.out.println(maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
      System.out.println(maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4, 6, -3, 1 }));
      System.out.println(maxSubArray(new int[] { 5, 4, -1, 7, 8 }));
      System.out.println(maxSubArray(new int[] { 8, -19, 5, -4, 20 }));
   }

   public static int maxSubArray(int[] nums) {
      int sum = nums[0];
      int tempSum = nums[0];
      int i = 1;
      while (i < nums.length) {
         int current = nums[i];
         if (tempSum <= 0) {
            if (current > tempSum) {
               tempSum = current;
            }
            if (tempSum > sum) {
               sum = tempSum;
            }
         } else {
            if (tempSum + current > 0) {
               tempSum += current;
               if (tempSum > sum) {
                  sum = tempSum;
               }
            } else {
               tempSum = current;
            }
         }
         i++;
      }
      return sum;
   }

}
