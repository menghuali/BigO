package algorithm.sec15_dynamicprogram;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/climbing-stairs/description/
 * 
 * You are climbing a staircase. It takes n steps to reach the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * 
 * Example 1:
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * 
 * Example 2:
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * 
 * Example 3:
 * Input: n = 4
 * Output: 5
 * 1 + 1 + 1 + 1
 * 2 + 1 + 1
 * 1 + 2 + 1
 * 1 + 1 + 2
 * 2 + 2
 * 
 * Constraints:
 * 1 <= n <= 45
 */
public class ClimbingStairs {

    private int climbStairs(int n, Map<Integer, Integer> cache) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        } else {
            int solution;
            if (n <= 2) {
                solution = n;
            } else {
                solution = climbStairs(n - 1, cache) + climbStairs(n - 2, cache);
            }
            cache.put(n, solution);
            return solution;
        } 
    }

    public int climbStairs(int n) {
        return climbStairs(n, new HashMap<>());
    }

    public static void main(String[] args) {
        ClimbingStairs cs = new ClimbingStairs();
        System.err.println(cs.climbStairs(1));
        System.err.println(cs.climbStairs(2));
        System.err.println(cs.climbStairs(3));
        System.err.println(cs.climbStairs(4));
        System.err.println(cs.climbStairs(45));
    }

}
