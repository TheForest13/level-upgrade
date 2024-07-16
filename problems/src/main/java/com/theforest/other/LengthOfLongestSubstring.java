package com.theforest.other;

// Given a string s, find the length of the longest
// substring
// without repeating characters.

// Example 1:

// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.
// Example 2:

// Input: s = "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.
// Example 3:

// Input: s = "pwwkew"
// Output: 3
// Explanation: The answer is "wke", wilth the length of 3.
// Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

// Constraints:

// 0 <= s.length <= 5 * 10^4
// s consists of English letters, digits, symbols and spaces.

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        LengthOfLongestSubstringSolution solution = new LengthOfLongestSubstringSolution();

        String case1 = "abcabcbb";  // 3
        String case2 = "bbbbb";     // 1
        String case3 = "pwwkew";    // 3
        System.out.println("result: " + solution.lengthOfLongestSubstring(case1));
        System.out.println("result: " + solution.lengthOfLongestSubstring(case2));
        System.out.println("result: " + solution.lengthOfLongestSubstring(case3));
    }
}

class LengthOfLongestSubstringSolution {

    private static final int DEFAULT_COUNT = 1;

    public int lengthOfLongestSubstring(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }
        char[] symbols = input.toCharArray();

        int count = 0;
        int maxCount = DEFAULT_COUNT;
        Set<Character> uniqSymbols = new HashSet<>();
        for (char symbol : symbols) {
            if (uniqSymbols.contains(symbol)) {
                uniqSymbols.clear();
                uniqSymbols.add(symbol);
                if (count > maxCount) {
                    maxCount = count;
                    count = DEFAULT_COUNT;
                }
            } else {
                count++;
                uniqSymbols.add(symbol);
            }
        }
        System.out.println("final: " + uniqSymbols);
        return maxCount;
    }
}