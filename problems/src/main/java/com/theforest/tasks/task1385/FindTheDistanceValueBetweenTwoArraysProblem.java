package com.theforest.tasks.task1385;

/**
 * https://leetcode.com/problems/find-the-distance-value-between-two-arrays/description/
 */
public class FindTheDistanceValueBetweenTwoArraysProblem {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int distance) {
        int count = 0;

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (Math.abs(arr1[i] - arr2[j]) <= distance) {
                    count++;
                    break;
                }
            }
        }
        return arr1.length - count;
    }
}
