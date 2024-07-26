package algorithm.sec15_dynamicprogram;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 * 
 * You are given an array prices where prices is the price of a given stock
 * on the ith day.
 * 
 * You want to maximize your profit by choosing a single day to buy one stock
 * and choosing a different day in the future to sell that stock.
 * 
 * Return the maximum profit you can achieve from this transaction. If you
 * cannot achieve any profit, return 0.
 * 
 * == Example 1 ==
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit =
 * 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you
 * must buy before you sell.
 * 
 * == Example 2 ==
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 * 
 * 
 * Constraints:
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 */
public class BestTimeBuySellStock {

    public int brutalForce(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                max = max < profit ? profit : max;
            }
        }
        return max;
    }

    public int dp(int[] prices) {
        int max = 0;
        HashMap<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < prices.length - 1; i++) {
            int maxPrice = maxPrice(prices, i + 1, cache);
            int profit = maxPrice - prices[i];
            max = max < profit ? profit : max;
        }
        return max;
    }

    private int maxPrice(int[] prices, int start, Map<Integer, Integer> cache) {
        if (cache.containsKey(start)) {
            return cache.get(start);
        } else {
            int max;
            if (start == prices.length - 1) {
                max = prices[start];
            } else {
                max = Math.max(prices[start], maxPrice(prices, start + 1, cache));
            }
            cache.put(start, max);
            return max;
        }
    }

    /**
     * Improved solution. It iterates the array for only once. The key is to use
     * minimum buy price.
     * 
     * Time: O(n)
     * Memory: O(1)
     */
    public int maxProfit(int[] prices) {
        int minBuy = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minBuy);
            minBuy = Math.min(prices[i], minBuy);
        }
        return maxProfit;
    }

    private static void maxProfit(int[] prices, Function<int[], Integer> function) {
        System.out.println(function.apply(prices));
    }

    public static void main(String[] args) {
        BestTimeBuySellStock buySell = new BestTimeBuySellStock();
        Function<int[], Integer> solution = buySell::maxProfit;

        int[] prices = new int[] { 7, 1, 5, 3, 6, 4 };
        maxProfit(prices, solution);

        prices = new int[] { 7, 6, 4, 3, 1 };
        maxProfit(prices, solution);

        prices = new int[] { 1 };
        maxProfit(prices, solution);
    }

}
