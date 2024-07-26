package algorithm.sec15_dynamicprogram;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * https://leetcode.com/problems/house-robber/description/
 * 
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed, the only constraint stopping you
 * from robbing each of them is that adjacent houses have security systems
 * connected and it will automatically contact the police if two adjacent houses
 * were broken into on the same night.
 * 
 * Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the
 * police.
 * 
 * == Example 1 ==
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * 
 * == Example 2 ==
 * Input: nums = [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5
 * (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 * 
 * == Constraints ==
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 */
public class HouseRobber {

    public int resursiveRob(int[] nums) {
        return Math.max(resursiveRob(nums, 0), resursiveRob(nums, 1));
    }

    private int resursiveRob(int[] nums, int index) {
        int len = nums.length - index;
        if (len < 1) {
            return 0;
        }
        if (len == 1) {
            return nums[index];
        }
        if (len == 2) {
            return Math.max(nums[index], nums[index + 1]);
        }
        return Math.max(nums[index] + resursiveRob(nums, index + 2), resursiveRob(nums, index + 1));
    }

    public int dpRob(int[] nums) {
        HashMap<Integer, Integer> cache = new HashMap<>();
        return Math.max(dpRob(nums, 0, cache), dpRob(nums, 1, cache));
    }

    private int dpRob(int[] nums, int index, Map<Integer, Integer> cache) {
        if (cache.containsKey(index)) {
            return cache.get(index);
        }

        int len = nums.length - index;
        int rob = 0;
        if (len < 1) {
            rob = 0;
        } else if (len == 1) {
            rob = nums[index];
        } else if (len == 2) {
            rob = Math.max(nums[index], nums[index + 1]);
        } else {
            rob = Math.max(nums[index] + dpRob(nums, index + 2, cache), dpRob(nums, index + 1, cache));
        }
        cache.put(index, rob);
        return rob;
    }

    public static void main(String[] args) {
        Function<int[], Integer> solution = new HouseRobber()::dpRob;

        int[] nums = new int[] { 1, 2, 3, 1 };
        rob(nums, solution);

        nums = new int[] { 2, 7, 9, 3, 1 };
        rob(nums, solution);

        nums = new int[] { 2, 1, 1, 2 };
        rob(nums, solution);
    }

    private static void rob(int[] nums, Function<int[], Integer> solution) {
        System.out.println(solution.apply(nums));
    }

}
