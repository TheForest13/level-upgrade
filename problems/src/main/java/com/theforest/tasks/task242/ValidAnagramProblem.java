package com.theforest.tasks.task242;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/valid-anagram/
 */
public class ValidAnagramProblem {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.isAnagram("anagram", "nagaram")); // true
        System.out.println(solution.isAnagram("rat", "car")); // false
    }
}

class Solution {
    public boolean isAnagram(String s, String t) {
        char[] strMas1 = s.toLowerCase().toCharArray();
        char[] strMas2 = t.toLowerCase().toCharArray();
        Arrays.sort(strMas1);
        Arrays.sort(strMas2);
        return new String(strMas1).equals(new String(strMas2));
    }
}