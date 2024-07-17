package com.theforest.tasks.task53;

/**
 * https://leetcode.com/problems/maximum-subarray/description/
 */
public class MaximumSubarrayProblem {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] case1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] case2 = {1};
        int[] case3 = {5, 4, -1, 7, 8};
        int[] case4 = {-1};
        int[] case5 = {1, 2};
        System.out.println(solution.maxSubArray(case1)); // 6 [4,-1,2,1]
        System.out.println(solution.maxSubArray(case2)); // 1 [1]
        System.out.println(solution.maxSubArray(case3)); // 23 [5,4,-1,7,8]
        System.out.println(solution.maxSubArray(case4)); // -1 [-1]
        System.out.println(solution.maxSubArray(case5)); // 3 [1,2]
    }
}

class Solution {
    public int maxSubArray(int[] nums) {
        int initialSum = nums[0];
        int sum = initialSum;
        int sumMax = initialSum;
        for (int currentNum : nums) {
            sum = Math.max(currentNum, sum + currentNum);
            sumMax = Math.max(sum, sumMax);
        }
        return sumMax;
    }
}