package com.theforest.tasks.task121;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BestTimeToBuyAndSellStockProblem {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] prices = {7, 1, 5, 3, 6, 4}; // Output: 5
        System.out.println(solution.maxProfit(prices));
    }
}

class Solution {

    public int maxProfit(int[] prices) {
        int profit = 0;
        int buy = prices[0];
        for (int sell: prices) {
            if (sell > buy) {
                profit = Math.max(profit, sell - buy);
            } else {
                buy = sell;
            }
        }
        return profit;
    }
}