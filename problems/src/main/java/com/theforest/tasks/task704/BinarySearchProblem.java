package com.theforest.tasks.task704;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/binary-search/description/
 */
public class BinarySearchProblem {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.search(new int[]{-1, 0, 3, 5, 9, 12}, 9));  // 4
        System.out.println(solution.search(new int[]{0, 1, 2, 3, 4, 5}, 4));    // 4
        System.out.println(solution.search(new int[]{0, 1, 2, 3, 4, 5, 6}, 4)); // 4
        System.out.println(solution.search(new int[]{5}, -5));                  // -1
    }
}

class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
