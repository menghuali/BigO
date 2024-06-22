package datastructure.array;

import java.util.HashSet;

/**
 * Given an integer array nums, return true if any value appears at least twice
 * in the array, and return false if every element is distinct.
 * 
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: true
 * 
 * Example 2:
 * Input: nums = [1,2,3,4]
 * Output: false
 * 
 * Example 3:
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 * 
 * Constraints:
 * 1 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 */
public class ContainDuplicates {

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[] { 1, 2, 3, 1 }));
        System.out.println(containsDuplicate(new int[] { 1, 2, 3, 4 }));
        System.out.println(containsDuplicate(new int[] { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 }));
        
    }

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> iterated = new HashSet<>();
        int i = 0;
        while (i < nums.length) {
            if (iterated.contains(nums[i]))
                return true;
            iterated.add(nums[i++]);
        }
        return false;
    }

}
