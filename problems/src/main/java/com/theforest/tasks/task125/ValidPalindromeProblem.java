package com.theforest.tasks.task125;

/**
 * https://leetcode.com/problems/valid-palindrome/
 */
public class ValidPalindromeProblem {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String case1 = "qwe, ewq"; // true
        String case2 = "race a car"; // false
        String case3 = "0P"; // false
        String case4 = "a"; // true
        String case5 = "ab_a"; // true
        System.out.println("case1: " + solution.isPalindrome(case1));
        System.out.println("case2: " + solution.isPalindrome(case2));
        System.out.println("case3: " + solution.isPalindrome(case3));
        System.out.println("case5: " + solution.isPalindrome(case5));
    }

}

class Solution {
    public boolean isPalindrome(String s) {
        String line = s.replaceAll("[\\W+|_]", "").toLowerCase();
        int length = line.length();
        if (line.isEmpty() || length == 1) {
            return true;
        }

        int mid = length / 2;
        if (length % 2 == 0) {
            return check(mid, mid, length, line);
        } else {
            return check(mid, mid + 1, length, line);
        }

    }

    private boolean check(int midFromSubOne,
                          int midFromSubTwo,
                          int length,
                          String line) {
        String subOne = line.substring(0, midFromSubOne);
        String subTwo = reverseString(line.substring(midFromSubTwo, length));
        return subOne.equals(subTwo);
    }

    private String reverseString(String str) {
        char[] array = str.toCharArray();
        String result = "";
        for (int i = array.length - 1; i >= 0; i--) {
            result = result + array[i];
        }
        return result;
    }

}