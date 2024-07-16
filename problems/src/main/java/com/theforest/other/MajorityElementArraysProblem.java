package com.theforest.other;
// Given an array nums of size n, return the majority element.
// The majority element is the element that appears more than [n / 2] times. You may assume that the majority element always exists in the array.

// Example 1:
// Input: nums = [3,2,3]
// Output: 3

// Example 2:
// Input: nums =[2,2,1,1,1,2,2]
// Output: 2

// Constraints:
// n == nums. length
// 1 <= n <= 5 * 104
// -109 <= nums[i] <= 109

// Follow-up: Could you solve the problem in linear time and in 0(1) space?

import java.util.HashMap;
import java.util.Map;

public class MajorityElementArraysProblem {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] case1 = {3, 2, 3}; // 3
        int[] case2 = {2,2,1,1,1,2,2}; // 2
        int[] case3 = {1, 1, 2, 2, 3, 1, 3, 3, 4, 1, 1, }; // 1
        System.out.println(solution.majorityElement(case1));
        System.out.println(solution.majorityElement(case2));
        System.out.println(solution.majorityElement(case3));
    }
}

class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> numToCount = new HashMap<>();
        int maxNum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];
            if (numToCount.containsKey(currentNum)) {
                int currentCount = numToCount.get(currentNum) + 1;
                numToCount.put(currentNum, currentCount);
                if (currentCount > numToCount.get(maxNum)) {
                    maxNum = currentNum;
                }
            } else {
                numToCount.put(currentNum, 1);
            }
        }
        return maxNum;
    }
}