package com.theforest.tasks.task3;

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
import java.util.concurrent.TimeUnit;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */
public class LengthOfLongestSubstring {
    private static final int DEFAULT_COUNT = 1;


    public int lengthOfLongestSubstring(String input) {
        int maxLength = 0;
        Set<Character> charSet = new HashSet<>();
        int left = 0;

        for (int right = 0; right < input.length(); right++) {
            if (!charSet.contains(input.charAt(right))) {
                charSet.add(input.charAt(right));
                maxLength = Math.max(maxLength, right - left + 1);
            } else {
                while (charSet.contains(input.charAt(right))) {
                    charSet.remove(input.charAt(left));
                    left++;
                }
                charSet.add(input.charAt(right));
            }
        }

        return maxLength;
    }

    public int lengthOfLongestSubstringVer2(String input) {
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
        if (count > maxCount) {
            maxCount = count;
        }
        return maxCount;
    }
}