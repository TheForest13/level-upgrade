package com.theforest.tasks.task462;

import java.util.Arrays;

public class MinimumMovesToEqualArrayElementsTwo {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        int median = nums[nums.length / 2];
        for (int num : nums) {
            ans += Math.abs(median - num);
        }
        return ans;
    }

    public static void main(String[] args) {
        MinimumMovesToEqualArrayElementsTwo solution = new MinimumMovesToEqualArrayElementsTwo();

//        int[] nums = {1, 2, 3}; // expect 2
//        int[] nums = {1,10,2,9}; // expect 16
        int[] nums = {1,0,0,8,6}; // expect 14 {0, 1, 1, 7, 5}

        System.out.println(solution.minMoves2(nums));
    }
}
