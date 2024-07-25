package com.theforest.tasks.task941;

/**
 * https://leetcode.com/problems/valid-mountain-array/description/
 */
public class ValidMountainArrayProblem {
    public boolean validMountainArray(int[] input) {
        int length = input.length;
        if (length < 3) {
            return false;
        }
        if (input[1] <= input[0]) {
            return false;
        }
        int i = 1;
        while (i < length && input[i] > input[i-1]) {
            i += 1;
        }
        if (i == length || input[i] == input[i-1]) {
            return false;
        }
        while (i < length && input[i] < input[i-1]) {
            i += 1;
        }
        if (i == length) {
            return true;
        }
        return false;
    }
}
